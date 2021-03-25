package com.UniAmerica.Prova41.service;

import com.UniAmerica.Prova41.model.Carro;
import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.model.Modelo;
import com.UniAmerica.Prova41.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro create(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro update(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Carro findById(Long id) {
        Optional<Carro> car = carroRepository.findById(id);
        if(car.isPresent()){
            return car.get();
        }
        else {
            return null;
        }
    }

    public void delete(Carro toDelete) {
        carroRepository.delete(toDelete);
    }

    public List<Carro> findByModelo(Modelo modelo) {
        return carroRepository.findByModelo(modelo);
    }

    public Object findByPlaca(String placa) {
        return carroRepository.findByPlaca(placa);
    }
}
