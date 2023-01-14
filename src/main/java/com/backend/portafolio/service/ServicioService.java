
package com.backend.portafolio.service;

import com.backend.portafolio.repository.ServicioRepository;
import com.backend.portafolio.entity.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {
    @Autowired
    public ServicioRepository servRepo;  
    
    public List<Servicio> verServicios() {
        return servRepo.findAll();
    }
    public void crearServicio(Servicio serv) {
        servRepo.save(serv);
    }

    public void eliminarServicio(Integer id) {
        servRepo.deleteById(id);
    }
 
    public Servicio buscarServicio(Integer id) {
        return servRepo.findById(id).orElse(null);           
    }                
}
