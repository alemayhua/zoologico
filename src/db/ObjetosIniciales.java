/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import modelo.Animal;
import modelo.Sector;
import modelo.Empleado;

/**
 *
 * @author selected
 */
public class ObjetosIniciales {

    Empleado empleado1 = new Empleado(123, "Florencia", "Gral. Paz");
    Empleado empleado2 = new Empleado(321, "Alejandro", "Entre Ríos");
    Empleado empleado3 = new Empleado(000, "Agostina", "Moreno");
    ArrayList<Animal> animalesSector1 = new ArrayList<>();
    ArrayList<Animal> animalesSector2 = new ArrayList<>();
    ArrayList<Animal> animalesSector3 = new ArrayList<>();
    Sector sector1 = new Sector(1, Color.GRAY, "-26.8227625, -65.185682", empleado1, animalesSector1);
    Sector sector2 = new Sector(2, Color.GRAY, "-26.831139, -65.184513", empleado2, animalesSector2);
    Sector sector3 = new Sector(3, Color.GRAY, "-26.832747, -65.188365", empleado3, animalesSector3);
    ArrayList<Sector> sectores = new ArrayList<>();

    public List<Sector> sectores() {
        sectores.clear();
        sectores.add(sector1);
        sectores.add(sector2);
        sectores.add(sector3);
        return sectores;
    }
}
