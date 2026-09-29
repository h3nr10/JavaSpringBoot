package com.javaprojs.paises.infrastructure.repository;

import com.javaprojs.paises.infrastructure.entitys.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findBySigla(String sigla);

    @Transactional
    void deleteBySigla(String sigla);
}