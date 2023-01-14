package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepositoryp extends JpaRepository<Estudio,Integer> {
        public Optional<Estudio> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
}
