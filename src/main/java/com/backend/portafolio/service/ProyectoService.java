package com.backend.portafolio.service;

import com.backend.portafolio.repository.ProyectoRepository;
import com.backend.portafolio.entity.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    @Autowired
    public ProyectoRepository proyRepo;  
    
    public List<Proyecto> verProyectos() {
        return proyRepo.findAll();
    }
    public void crearProyecto(Proyecto proy) {
        proyRepo.save(proy);
    }

    public void eliminarProyecto(Integer id) {
        proyRepo.deleteById(id);
    }
 
    public Proyecto buscarProyecto(Integer id) {
        return proyRepo.findById(id).orElse(null);           
    }   
    
}
