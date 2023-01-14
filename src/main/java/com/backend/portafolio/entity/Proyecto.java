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
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;    
    @Column(length = 100)    
    private String titulo;
    @Column(length = 100)
    private String programa;
    @Column(length = 100)
    private String fechas;
    @Column(length = 1000)
    private String descripcion;
    @Column(length = 5000)
    private String url_imagen;
    @Column(length = 5000)
    private String url;

    @Column (name= "persona_id")
    private Integer personaId;


    public Proyecto() {
    }

    public Proyecto(Integer id, String titulo, String programa, String fechas, String descripcion, String url_imagen, String url, Integer personaId) {
        this.id = id;
        this.titulo = titulo;
        this.programa = programa;
        this.fechas = fechas;
        this.descripcion = descripcion;
        this.url_imagen = url_imagen;
        this.url = url;
        this.personaId = personaId;
    }
}