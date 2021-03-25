package com.UniAmerica.Prova41.repository;

import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findAllByMarca (Marca marca);

    Modelo findByName(String nomeModelo);
}
