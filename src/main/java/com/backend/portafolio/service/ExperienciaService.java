package com.backend.portafolio.service;

import com.backend.portafolio.repository.ExperienciaRepository;
import com.backend.portafolio.entity.Experiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    @Autowired
    public ExperienciaRepository expeRepo;  
     
    public List<Experiencia> verExperiencias() {
        return expeRepo.findAll();
    }
    public void crearExperiencia(Experiencia estu) {
        expeRepo.save(estu);
    }

    public void eliminarExperiencia(Integer id) {
        expeRepo.deleteById(id);
    }
 
    public Experiencia buscarExperiencia(Integer id) {
        return expeRepo.findById(id).orElse(null);           
    }                
}
