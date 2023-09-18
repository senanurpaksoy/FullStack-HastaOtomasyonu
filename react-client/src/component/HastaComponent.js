import React, {useState, useEffect} from 'react';
import HastaService from '../service/HastaService';

function HastaComponent() {
    const [hastalar, setHastalar] = useState([]);
    const [yeniHasta, setYeniHasta] = useState({
        firstname: '',
        lastname: '',
        birthdate: ''
    });
    const [guncellenecekHasta, setGuncellenecekHasta] = useState(null);

    useEffect(() => {
        refreshHastaListesi();
    }, []);

    const refreshHastaListesi = () => {
        HastaService.getUsers().then((response) => {
            setHastalar(response.data);
        });
    }

    const handleInputChange = (event) => {
        const {name, value} = event.target;
        setYeniHasta({
            ...yeniHasta,
            [name]: value
        });
    }

    const handleHastaEkle = () => {
        HastaService.createHasta(yeniHasta).then(() => {
            refreshHastaListesi();
            setYeniHasta({
                firstname: '',
                lastname: '',
                birthdate: ''
            });
        });
    }

    const handleGuncellemeClick = (hasta) => {
        setGuncellenecekHasta(hasta);
        setYeniHasta({
            firstname: hasta.firstname,
            lastname: hasta.lastname,
            birthdate: hasta.birthdate
        });
    }

    const handleHastaGuncelle = () => {
        if (!guncellenecekHasta) return;

        HastaService.updateHasta(guncellenecekHasta.id, yeniHasta)
            .then(() => {
                refreshHastaListesi();
                setGuncellenecekHasta(null);
                setYeniHasta({
                    firstname: '',
                    lastname: '',
                    birthdate: ''
                });
            })
            .catch((error) => {
                console.error("Güncelleme işlemi sırasında hata oluştu:", error);
            });
    }

    const handleHastaSil = (id) => {
        console.log(id)
        if (window.confirm('Bu hastayı silmek istediğinizden emin misiniz?')) {
            HastaService.deleteHasta(id).then(() => {
                refreshHastaListesi();
            });
        }
    }

    return (
        <div>
            <h1 className="text-center">Hasta Listesi</h1>
            <form>
                <input
                    type="text"
                    name="firstname"
                    placeholder="Ad"
                    value={yeniHasta.firstname}
                    onChange={handleInputChange}
                />
                <input
                    type="text"
                    name="lastname"
                    placeholder="Soyad"
                    value={yeniHasta.lastname}
                    onChange={handleInputChange}
                />
                <input
                    type="text"
                    name="birthdate"
                    placeholder="Doğum Tarihi"
                    value={yeniHasta.birthdate}
                    onChange={handleInputChange}
                />
                <button type="button" onClick={handleHastaEkle}>
                    Hasta Ekle
                </button>
            </form>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Hasta First Name</th>
                    <th>Hasta Last Name</th>
                    <th>Hasta Birthdate</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {hastalar.map((hasta, index) => (
                    <tr key={index}>
                        <td>{hasta.firstname}</td>
                        <td>{hasta.lastname}</td>
                        <td>{hasta.birthdate}</td>
                        <td>
                            <button onClick={() => handleGuncellemeClick(hasta)}>Düzenle</button>
                            <button onClick={() => handleHastaSil(hasta.id)}>Sil</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            {guncellenecekHasta && (
                <div>
                    <h2>Güncelleme Formu</h2>
                    <input
                        type="text"
                        name="firstname"
                        value={yeniHasta.firstname}
                        onChange={handleInputChange}
                    />
                    <input
                        type="text"
                        name="lastname"
                        value={yeniHasta.lastname}
                        onChange={handleInputChange}
                    />
                    <input
                        type="text"
                        name="birthdate"
                        value={yeniHasta.birthdate}
                        onChange={handleInputChange}
                    />
                    <button onClick={handleHastaGuncelle}>Güncelle</button>
                </div>
            )}
        </div>
    );
}

export default HastaComponent;
