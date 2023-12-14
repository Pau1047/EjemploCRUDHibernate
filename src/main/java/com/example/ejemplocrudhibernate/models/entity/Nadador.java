package com.example.ejemplocrudhibernate.models.entity;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="nadador")
public class Nadador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="numfederado",unique = true)
    private int numfederado;

    @Column(name="edad")
    private int edad;

    @Column(name="email",unique = true)
    private String email;

    public Nadador( String nombre, int numfederado, int edad, String email) {
        this.nombre = nombre;
        this.numfederado = numfederado;
        this.edad = edad;
        this.email = email;
    }

    public Nadador(){

    }


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    public int getNumfederado() {return numfederado;}

    public void setNumfederado(int numfederado) {this.numfederado = numfederado;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    private static final long serialVersionUID = 1L;
}
