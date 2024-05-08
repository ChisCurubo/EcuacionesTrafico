package co.edu.upb;

import java.util.Comparator;
import java.util.LinkedList;

public class Simulacion {

    LinkedList<LinkedList<Vehiculo>> vehiculos;

    public Simulacion(){
        vehiculos = new LinkedList<>();
    }

    public void sortBy(){
        vehiculos.sort(Comparator.comparingInt(LinkedList::size));
    }

}
