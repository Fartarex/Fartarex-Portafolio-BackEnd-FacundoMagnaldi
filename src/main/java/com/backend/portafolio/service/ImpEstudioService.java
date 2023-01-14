package com.backend.portafolio.service;

import com.backend.portafolio.entity.Estudio;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.portafolio.repository.IEstudioRepositoryp;

@Service
@Transactional
public class ImpEstudioService {
   @Autowired IEstudioRepositoryp iEstudioRepository; 
     
     public List<Estudio> list(){
        return iEstudioRepository.findAll();
     }
     
public Optional<Estudio> getOne(int id){
    return iEstudioRepository.findById(id);
}
public Optional<Estudio> getByTitulo(String titulo){
    return iEstudioRepository.findByTitulo(titulo);
}
public void save(Estudio estudio){
    iEstudioRepository.save(estudio);
}
public void delete(int id){
    iEstudioRepository.deleteById(id);
}

public boolean existsById(int id){
    return iEstudioRepository.existsById(id);
}
public boolean existsByTitulo(String titulo){
    return iEstudioRepository.existsByTitulo(titulo);
}
    
}
