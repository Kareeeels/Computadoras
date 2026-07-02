package com.computadoras.controller;

import com.computadoras.model.Computadora;
import com.computadoras.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computadoras")
@CrossOrigin(origins = "*")
public class ComputadoraController {

    @Autowired
    private ComputadoraService computadoraService;

    @GetMapping
    public List<Computadora> getAllComputadoras() {
        return computadoraService.findAll();
    }

    @GetMapping("/{id}")
    public Computadora getComputadoraById(@PathVariable Long id) {
        return computadoraService.findById(id)
                .orElseThrow(() -> new RuntimeException("Computadora no encontrada"));
    }

    @PostMapping
    public Computadora createComputadora(@RequestBody Computadora computadora) {
        return computadoraService.save(computadora);
    }

    @PutMapping("/{id}")
    public Computadora updateComputadora(@PathVariable Long id, @RequestBody Computadora computadora) {
        return computadoraService.update(id, computadora);
    }

    @DeleteMapping("/{id}")
    public void deleteComputadora(@PathVariable Long id) {
        computadoraService.delete(id);
    }
}
