/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.*;
import db.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Animal;
import modelo.Carnivoro;
import modelo.Herbivoro;
import modelo.Sector;

/**
 *
 * @author selected
 */
public class ControladorPrincipal {

    static VistaPrincipal vistaPrincipal = new VistaPrincipal();
    static VistaAgregarAnimal vistaAgregarAnimal = new VistaAgregarAnimal();
    static ObjetosIniciales oi = new ObjetosIniciales();

    public static void mostrarVistaPrincipal() {
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
        llenarSectores();
    }

    public static void mostrarVistaAgregarAnimal() {
        vistaAgregarAnimal.setVisible(true);
        vistaAgregarAnimal.setLocationRelativeTo(null);
        vistaAgregarAnimal.getBtnAgregar().setEnabled(false);
        vistaAgregarAnimal.getCbSector().removeAllItems();
        vistaAgregarAnimal.getGrupoTipo().clearSelection();
        vistaAgregarAnimal.getTxtEdad().setText("");
        vistaAgregarAnimal.getTxtEspecie().setText("");
        vistaAgregarAnimal.getTxtPais().setText("");
        vistaAgregarAnimal.getTxtPeso().setText("");
    }

    public static void botonCalcularComida() {
        double kgsHerbivoro = 0, kgsCarnivoro = 0, kgsTotal = 0;
        for (Sector sector : oi.sectores()) {
            for (Animal animal : sector.getAnimales()) {
                if (animal instanceof Carnivoro) {
                    kgsCarnivoro += ((Carnivoro) animal).calcularComidaDiaria();
                } else {
                    kgsHerbivoro += ((Herbivoro) animal).calcularComidaDiaria();
                }
            }
        }
        kgsTotal = kgsCarnivoro + kgsHerbivoro;
        vistaPrincipal.getLblKgCarnivoros().setText("" + kgsCarnivoro);
        vistaPrincipal.getLblKgHerbivoros().setText("" + kgsHerbivoro);
        vistaPrincipal.getLblKgTotal().setText("" + kgsTotal);
    }

    public static void llenarEtiquetasSectores(Sector sector, JLabel id, JPanel fondoColor, JLabel especies, JLabel cantidad, JLabel coordenadas, JLabel empleado) {
        id.setText("" + sector.getId());
        int contador = 0;
        StringBuilder especiesBuilder = new StringBuilder();
        for (Animal animal : sector.getAnimales()) {
            especiesBuilder.append(animal.getEspecie());
            if (++contador < sector.getAnimales().size()) {
                especiesBuilder.append(", ");
            }
        }
        especies.setText(especiesBuilder.toString());
        fondoColor.setBackground(sector.getColor());
        cantidad.setText("" + sector.getAnimales().size());
        coordenadas.setText("" + sector.getCoordenadas());
        empleado.setText("" + sector.getEmpleado().getNombre());
    }

    public static void llenarSectores() {
        for (Sector sector : oi.sectores()) {
            switch (sector.getId()) {
                case 1:
                    llenarEtiquetasSectores(sector, vistaPrincipal.getLblIdSector1(), vistaPrincipal.getSector1(), vistaPrincipal.getLblEspeciesSector1(), vistaPrincipal.getLblCantidadSector1(), vistaPrincipal.getLblCoordSector1(), vistaPrincipal.getLblEmpleado1());
                    break;
                case 2:
                    llenarEtiquetasSectores(sector, vistaPrincipal.getLblIdSector2(), vistaPrincipal.getSector2(), vistaPrincipal.getLblEspeciesSector2(), vistaPrincipal.getLblCantidadSector2(), vistaPrincipal.getLblCoordSector2(), vistaPrincipal.getLblEmpleado2());
                    break;
                case 3:
                    llenarEtiquetasSectores(sector, vistaPrincipal.getLblIdSector3(), vistaPrincipal.getSector3(), vistaPrincipal.getLblEspeciesSector3(), vistaPrincipal.getLblCantidadSector3(), vistaPrincipal.getLblCoordSector3(), vistaPrincipal.getLblEmpleado3());
            }
        }
    }
}
