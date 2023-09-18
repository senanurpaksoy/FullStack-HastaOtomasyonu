package com.hs.hastaservice.mapper;

import com.hs.hastaservice.dto.HastaDTO;
import com.hs.hastaservice.entity.Hasta;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-18T20:48:51+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
public class HastaMapperImpl implements HastaMapper {

    @Override
    public Hasta toEntity(HastaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Hasta hasta = new Hasta();

        hasta.setId( dto.getId() );
        hasta.setFirstname( dto.getFirstname() );
        hasta.setLastname( dto.getLastname() );
        hasta.setBirthdate( dto.getBirthdate() );

        return hasta;
    }

    @Override
    public HastaDTO toDto(Hasta entity) {
        if ( entity == null ) {
            return null;
        }

        HastaDTO.HastaDTOBuilder hastaDTO = HastaDTO.builder();

        hastaDTO.id( entity.getId() );
        hastaDTO.firstname( entity.getFirstname() );
        hastaDTO.lastname( entity.getLastname() );
        hastaDTO.birthdate( entity.getBirthdate() );

        return hastaDTO.build();
    }
}
