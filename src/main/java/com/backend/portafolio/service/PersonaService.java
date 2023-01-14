package com.backend.portafolio.service;

import com.backend.portafolio.repository.PersonaRepository;
import com.backend.portafolio.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    public PersonaRepository persoRepo;    
    
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    public void crearPersona(Persona pers) {
        persoRepo.save(pers);
    }

    public void eliminarPersona(Integer id) {
        persoRepo.deleteById(id);
    }
 
    public Persona buscarPersona(Integer id) {
        return persoRepo.findById(id).orElse(null);           
    }    

    public Persona loginPersona(String correo, String clave) {
        List <Persona> personas = persoRepo.findByCorreoAndContrasena(correo, clave);
        
        if(!personas.isEmpty()){
            return personas.get(0);                        
        }
        return null;
    }          
}

