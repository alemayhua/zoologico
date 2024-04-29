/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author selected
 */
public class Carnivoro extends Animal {

    public Carnivoro(String especie, int edad, String paisOrigen, float peso) {
        super(especie, edad, paisOrigen, peso);
    }

    public double calcularComidaDiaria() {
        double comidaDiaria = getPeso() * 0.05;
        return (getPeso() < 500 ? comidaDiaria : comidaDiaria + (comidaDiaria * 0.1));
    }
}
