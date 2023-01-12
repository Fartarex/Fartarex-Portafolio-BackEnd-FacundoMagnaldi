package com.backend.portafolio.service;

import com.backend.portafolio.entity.Usuarios;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.portafolio.repository.IUsuariosRepository;

@Service
@Transactional
public class ImpUsuarioService {
    @Autowired IUsuariosRepository iUsuariosRepository; 
    
    
public List<Usuarios> list(){
    
        return iUsuariosRepository.findAll();
        
    }
public Optional<Usuarios> getOne(int id){
    return iUsuariosRepository.findById(id);
}
public Optional<Usuarios> getByNombre(String nombre){
return iUsuariosRepository.findByNombre(nombre);
}
public void save(Usuarios usuarios){
    iUsuariosRepository.save(usuarios);
}
public void delete(int id){
    iUsuariosRepository.deleteById(id);
}

public boolean existsById(int id){
    return iUsuariosRepository.existsById(id);
}
public boolean existsByNombre(String nombre){
return iUsuariosRepository.existsByNombre(nombre);
}
    
}
