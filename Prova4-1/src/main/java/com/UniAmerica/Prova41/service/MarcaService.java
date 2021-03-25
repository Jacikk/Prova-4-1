package com.UniAmerica.Prova41.service;

import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca findByName(String name) {

        return marcaRepository.findByName(name);
    }

    public Marca create(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca findById(Long id) {
        Optional<Marca> m = marcaRepository.findById(id);
        if(m.isPresent()){
            return m.get();
        }
        else {
            return null;
        }
    }

    public Marca update(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void delete(Marca toDelete) {
        marcaRepository.delete(toDelete);
    }

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }
}
