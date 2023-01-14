package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository_3 extends JpaRepository<Experiencia,Integer> {
        public Optional<Experiencia> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
