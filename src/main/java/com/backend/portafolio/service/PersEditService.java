package com.backend.portafolio.service;

import com.backend.portafolio.entity.Persona;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PersEditService {
    
    public Iterable<Persona> findAll();
    
    public Page<Persona> findAll(Pageable pageable);
    
    public Optional<Persona> findById(Long id);
    
    public Persona save(Persona persona);
    
    public void deleteById(Long id);
}
