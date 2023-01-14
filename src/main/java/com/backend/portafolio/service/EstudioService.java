package com.backend.portafolio.service;

import com.backend.portafolio.repository.EstudioRepository;
import com.backend.portafolio.entity.Estudio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService {
    @Autowired
    public EstudioRepository estuRepo;  
    
    public List<Estudio> verEstudios() {
        return estuRepo.findAll();
    }
    public void crearEstudio(Estudio estu) {
        estuRepo.save(estu);
    }

    public void eliminarEstudio(Integer id) {
        estuRepo.deleteById(id);
    }
 
    public Estudio buscarEstudio(Integer id) {
        return estuRepo.findById(id).orElse(null);           
    }            
}
