package com.backend.portafolio.security.service;

import com.backend.portafolio.security.entity.Rol;
import com.backend.portafolio.security.enums.RolNombre;
import com.backend.portafolio.security.repository.IRolRepository;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);        
    }
    
    public void save(Rol rol) {
        irolRepository.save(rol);
        
    }
}
