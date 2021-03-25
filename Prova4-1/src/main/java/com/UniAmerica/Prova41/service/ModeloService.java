package com.UniAmerica.Prova41.service;

import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.model.Modelo;
import com.UniAmerica.Prova41.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public Modelo create(Modelo modelo) {
        modelo.setName(modelo.getName().toLowerCase());
        return modeloRepository.save(modelo);
    }

    public Modelo update(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo findById(Long id) {
        Optional<Modelo> m = modeloRepository.findById(id);
        if(m.isPresent()){
            return m.get();
        }
        else {
            return null;
        }
    }

    public void delete(Modelo toDelete) {
        modeloRepository.delete(toDelete);
    }

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    public List<Modelo> findByMarca(Marca marca) {
        return modeloRepository.findAllByMarca(marca);
    }

    public Modelo findByName(String nomeModelo) {
        return modeloRepository.findByName(nomeModelo);
    }
}
