package com.backend.portafolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table (name= "usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String nombre;
    @Column(length = 200)
    private String apellido;
    @Column(length = 500)
    private String contrasena;
    @Column(length = 500)
    private String correo; 
    
    public Usuarios() {

    }

    public Usuarios(Integer id, String nombre, String apellido, String contrasena, String correo) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
    }
}
