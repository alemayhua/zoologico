/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.ObjetosIniciales;
import java.awt.Color;
import modelo.Animal;
import modelo.Carnivoro;
import modelo.Herbivoro;
import vista.VistaAgregarAnimal;

/**
 *
 * @author selected
 */
public class ControladorAgregarAnimal {

    static VistaAgregarAnimal vistaAgregarAnimal = ControladorPrincipal.vistaAgregarAnimal;
    static ObjetosIniciales oi = ControladorPrincipal.oi;

    public static void botonAgregar() {
        String especie = vistaAgregarAnimal.getTxtEspecie().getText();
        int edad = Integer.parseInt(vistaAgregarAnimal.getTxtEdad().getText());
        String paisOrigen = vistaAgregarAnimal.getTxtPais().getText();
        float peso = Float.parseFloat(vistaAgregarAnimal.getTxtPeso().getText());
        if (vistaAgregarAnimal.getRbtnCarnivoro().isSelected()) {
            Animal animal = new Carnivoro(especie, edad, paisOrigen, peso);
            agregarAnimalSectorSeleccionado(animal);
        } else {
            Animal animal = new Herbivoro(especie, edad, paisOrigen, peso);
            agregarAnimalSectorSeleccionado(animal);
        }
        ControladorPrincipal.llenarSectores();
        vistaAgregarAnimal.dispose();
    }

    public static void agregarAnimalSectorSeleccionado(Animal animal) {
        switch (vistaAgregarAnimal.getCbSector().getSelectedItem().toString()) {
            case "1":
                oi.sectores().get(0).getAnimales().add(animal);
                oi.sectores().get(0).setColor(animal instanceof Carnivoro ? Color.YELLOW : Color.GREEN);
                break;
            case "2":
                oi.sectores().get(1).getAnimales().add(animal);
                oi.sectores().get(1).setColor(animal instanceof Carnivoro ? Color.YELLOW : Color.GREEN);
                break;
            case "3":
                oi.sectores().get(2).getAnimales().add(animal);
                oi.sectores().get(2).setColor(animal instanceof Carnivoro ? Color.YELLOW : Color.GREEN);
                break;
        }
    }

    public static void radioButtonCarnivoro() {
        vistaAgregarAnimal.getCbSector().removeAllItems();
        llenarComboBoxSector(Color.YELLOW);
        vistaAgregarAnimal.getCbSector().setEnabled(true);
        vistaAgregarAnimal.getBtnAgregar().setEnabled(true);
    }

    public static void radioButtonHerbivoro() {
        vistaAgregarAnimal.getCbSector().removeAllItems();
        llenarComboBoxSector(Color.GREEN);
        vistaAgregarAnimal.getCbSector().setEnabled(true);
        vistaAgregarAnimal.getBtnAgregar().setEnabled(true);
    }

    public static void llenarComboBoxSector(Color color) {
        oi.sectores().stream().filter((sector) -> (sector.getColor() == color || sector.getColor() == Color.GRAY)).forEachOrdered((sector) -> {
            vistaAgregarAnimal.getCbSector().addItem("" + sector.getId());
        });
    }

    public static void botonCancelar() {
        vistaAgregarAnimal.dispose();
    }
}
