package com.hs.hastaservice.service.impl;

import com.hs.hastaservice.dto.HastaDTO;
import com.hs.hastaservice.entity.Hasta;
import com.hs.hastaservice.mapper.HastaMapper;
import com.hs.hastaservice.repository.HastaRepository;
import com.hs.hastaservice.service.HastaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HastaServiceImpl implements HastaService {

    private final HastaRepository hastaRepository;
    private final HastaMapper hastaMapper = HastaMapper.MAPPER;

    public HastaServiceImpl(HastaRepository hastaRepository) {
        this.hastaRepository = hastaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HastaDTO> getAll() {

        List<Hasta> hastaList = hastaRepository.findAll();
        return hastaList.stream().map(hasta -> hastaMapper.toDto(hasta)).collect(Collectors.toList());
    }

    @Override
    public Optional<Hasta> get(Long id) {
        return hastaRepository.findById(id);
    }

    @Override
    public Hasta save(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    @Override
    public void delete(Long id) {
        hastaRepository.deleteById(id);
    }
}
