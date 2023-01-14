package com.backend.portafolio.service;

import com.backend.portafolio.entity.Proyecto;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.portafolio.repository.IProyectoRepository_2;

@Service
@Transactional
public class ImpProyectoService {
   @Autowired IProyectoRepository_2 iProyectoRepository_2; 
     
     public List<Proyecto> list(){
        return iProyectoRepository_2.findAll();
     }
     
public Optional<Proyecto> getOne(int id){
    return iProyectoRepository_2.findById(id);
}
public Optional<Proyecto> getByTitulo(String titulo){
    return iProyectoRepository_2.findByTitulo(titulo);
}
public void save(Proyecto experiencia){
    iProyectoRepository_2.save(experiencia);
}
public void delete(int id){
    iProyectoRepository_2.deleteById(id);
}

public boolean existsById(int id){
    return iProyectoRepository_2.existsById(id);
}
public boolean existsByTitulo(String titulo){
    return iProyectoRepository_2.existsByTitulo(titulo);
}
    
}
