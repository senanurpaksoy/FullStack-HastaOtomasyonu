package com.hs.hastaservice.mapper;

import com.hs.hastaservice.dto.HastaDTO;
import com.hs.hastaservice.entity.Hasta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HastaMapper {
    HastaMapper MAPPER = Mappers.getMapper(HastaMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "birthdate", source = "birthdate")
    Hasta toEntity(HastaDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "birthdate", source = "birthdate")
    HastaDTO toDto(Hasta entity);

}
