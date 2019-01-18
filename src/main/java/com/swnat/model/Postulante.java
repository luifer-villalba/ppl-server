package com.swnat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "postulante", schema = "management")
public class Postulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "documento")
    private String documento;

    @Column(name = "curriculum_url")
    private String curriculumUrl;

    @Column(name = "nro_celular")
    private String celular;

    @Column(name = "desafio_url")
    private String desafioUrl;

    @Column(name = "mail")
    private String mail;

    @Column(name = "comentario")
    private String comentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurriculumUrl() {
        return curriculumUrl;
    }

    public void setCurriculumUrl(String curriculumUrl) {
        this.curriculumUrl = curriculumUrl;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDesafioUrl() {
        return desafioUrl;
    }

    public void setDesafioUrl(String desafioUrl) {
        this.desafioUrl = desafioUrl;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
