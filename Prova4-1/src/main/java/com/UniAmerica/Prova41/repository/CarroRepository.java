package com.UniAmerica.Prova41.repository;

import com.UniAmerica.Prova41.model.Carro;
import com.UniAmerica.Prova41.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByModelo(Modelo modelo);

    Object findByPlaca(String placa);
}
