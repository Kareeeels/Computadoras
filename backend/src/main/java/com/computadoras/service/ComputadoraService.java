package com.computadoras.service;

import com.computadoras.model.Computadora;
import com.computadoras.repository.ComputadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadoraService {

    @Autowired
    private ComputadoraRepository computadoraRepository;

    public List<Computadora> findAll() {
        return computadoraRepository.findAll();
    }

    public Optional<Computadora> findById(Long id) {
        return computadoraRepository.findById(id);
    }

    public Computadora save(Computadora computadora) {
        return computadoraRepository.save(computadora);
    }

    public Computadora update(Long id, Computadora computadoraDetails) {
        Computadora computadora = computadoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Computadora no encontrada"));
        computadora.setMarca(computadoraDetails.getMarca());
        computadora.setModelo(computadoraDetails.getModelo());
        computadora.setPrecio(computadoraDetails.getPrecio());
        computadora.setDescripcion(computadoraDetails.getDescripcion());
        return computadoraRepository.save(computadora);
    }

    public void delete(Long id) {
        computadoraRepository.deleteById(id);
    }
}
