package com.backend.portafolio.service;

import com.backend.portafolio.entity.Usuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.portafolio.repository.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    public UsuariosRepository usersRepo;    
    
    public List<Usuarios> verUsers() {
        return usersRepo.findAll();
    }

    public void crearUsers(Usuarios pers) {
        usersRepo.save(pers);
    }

    public void eliminarUsers(Integer id) {
        usersRepo.deleteById(id);
    }
 
    public Usuarios buscarUsers(Integer id) {
        return usersRepo.findById(id).orElse(null);           
    }    

    public Usuarios loginUsers(String correo, String clave) {
        List <Usuarios> users = usersRepo.findByCorreoAndContrasena(correo, clave);
        
        if(!users.isEmpty()){
            return users.get(0);                        
        }
        return null;
    }          
}

