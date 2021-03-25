package com.UniAmerica.Prova41.repository;

import com.UniAmerica.Prova41.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findAllByName(String name);

    Marca findByName(String name);
}
