package com.backend.portafolio.repository;

import com.backend.portafolio.entity.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface UsuariosRepository extends JpaRepository <Usuarios, Integer> {
    public List<Usuarios> findByCorreoAndContrasena(String correo, String contrasena);
}   



