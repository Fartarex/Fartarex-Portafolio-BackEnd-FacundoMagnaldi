package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository_2 extends JpaRepository<Proyecto,Integer> {
        public Optional<Proyecto> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
