package com.backend.portafolio.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;        
    private String titulo;
    private String descripcion;
    private String url_imagen;
    @Column (name= "persona_id")
    private Integer personaId;

    public Servicio() {
    }

    public Servicio(Integer id, String titulo, String descripcion, String url_imagen, Integer personaId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
        this.personaId = personaId;
    }           
}
