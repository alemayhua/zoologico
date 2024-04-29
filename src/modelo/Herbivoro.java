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
public class Herbivoro extends Animal{
 
    public Herbivoro(String especie, int edad, String paisOrigen, float peso) {
        super(especie, edad, paisOrigen, peso);
    }
    
    public double calcularComidaDiaria(){
        return (getPeso() * 2) + 10;
    }
}
