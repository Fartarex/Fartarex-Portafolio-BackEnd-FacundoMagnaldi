
package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer> {
    public List<Persona> findByCorreoAndContrasena(String correo, String contrasena);
}
