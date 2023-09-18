package com.hs.hastaservice.controller;

import com.hs.hastaservice.dto.HastaDTO;
import com.hs.hastaservice.entity.Hasta;
import com.hs.hastaservice.service.HastaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/hasta")
public class HastaController {

    private final HastaService hastaService;

    public HastaController(HastaService hastaService) {
        this.hastaService = hastaService;
    }

    @GetMapping
    public List<HastaDTO> getAll() {
        return hastaService.getAll();
    }

    @GetMapping("/{id}")
    public Hasta get(@PathVariable Long id) {
        return hastaService.get(id).orElseThrow(() -> new RuntimeException("Hasta bulunamadı"));
    }

    @PostMapping
    public Hasta create(@RequestBody Hasta hasta) {
        return hastaService.save(hasta);
    }

    @PutMapping
    public Hasta update(@RequestBody Hasta hasta) {
        if (hasta.getId() == null || hasta.getId() <= 0)
            throw new RuntimeException("Hasta id boş olamaz");
        return hastaService.save(hasta);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        hastaService.delete(id);
        return true;
    }

}
