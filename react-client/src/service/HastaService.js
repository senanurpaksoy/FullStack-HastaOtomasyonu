import axios from 'axios';

const HASTA_REST_API_URL = 'http://localhost:8089/api/v1/hasta';

class HastaService {
    getUsers() {
        return axios.get(HASTA_REST_API_URL);
    }

    createHasta(hasta) {
        return axios.post(HASTA_REST_API_URL, hasta);
    }

    updateHasta( id,hasta) {
        return axios.put(HASTA_REST_API_URL, hasta);
    }

    deleteHasta(id) {
        return axios.delete(`${HASTA_REST_API_URL}/${id}`);
    }
}

export default new HastaService();
