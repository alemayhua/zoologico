/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author selected
 */
public class Sector {
    private int id;
    private Color color;
    private String coordenadas;
    private Empleado empleado;
    private List<Animal> animales;

    public Sector(int id, Color color, String coordenadas, Empleado empleado, List<Animal> animales) {
        this.id = id;
        this.color = color;
        this.coordenadas = coordenadas;
        this.empleado = empleado;
        this.animales = animales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
    
}
