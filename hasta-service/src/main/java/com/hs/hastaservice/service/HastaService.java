package com.hs.hastaservice.service;

import com.hs.hastaservice.dto.HastaDTO;
import com.hs.hastaservice.entity.Hasta;

import java.util.List;
import java.util.Optional;

public interface HastaService {
    List<HastaDTO> getAll();

    Optional<Hasta> get(Long id);

    Hasta save(Hasta hasta);

    void delete(Long id);
}
