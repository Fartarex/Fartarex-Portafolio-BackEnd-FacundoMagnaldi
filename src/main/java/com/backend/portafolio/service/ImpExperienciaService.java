package com.backend.portafolio.service;

import com.backend.portafolio.entity.Experiencia;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.portafolio.repository.IExperienciaRepository_3;

@Service
@Transactional
public class ImpExperienciaService {
   @Autowired IExperienciaRepository_3 iExperienciaRepository; 
     
     public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
     }
     
public Optional<Experiencia> getOne(int id){
    return iExperienciaRepository.findById(id);
}
public Optional<Experiencia> getByTitulo(String titulo){
    return iExperienciaRepository.findByTitulo(titulo);
}
public void save(Experiencia experiencia){
    iExperienciaRepository.save(experiencia);
}
public void delete(int id){
    iExperienciaRepository.deleteById(id);
}

public boolean existsById(int id){
    return iExperienciaRepository.existsById(id);
}
public boolean existsByTitulo(String titulo){
    return iExperienciaRepository.existsByTitulo(titulo);
}
    
}
