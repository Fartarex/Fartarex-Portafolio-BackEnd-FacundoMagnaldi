package com.backend.portafolio.entity;

import java.io.Serializable;
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
@Table
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;      
    @Column(length = 100)
    private String titulo;
    @Column(length = 100)
    private String empresa;
    @Column (name= "persona_id")
    private Integer personaId;
    @Column(length = 100)
    private String fechas;
    @Column(length = 2000)
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(Integer id, String titulo, String empresa, Integer personaId, String fechas, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.empresa = empresa;
        this.personaId =  personaId;
        this.fechas = fechas;
        this.descripcion = descripcion;
    }
    
    
    
}
