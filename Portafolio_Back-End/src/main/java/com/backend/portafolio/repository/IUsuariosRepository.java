package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {
        public Optional<Usuarios> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
