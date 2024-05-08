package co.edu.upb;

import java.util.Comparator;
import java.util.LinkedList;

public class Simulacion {
    LinkedList<TimeStep> vehiculos;
    double totalSpeed;

    public Simulacion() {
        vehiculos = new LinkedList<>();
        totalSpeed = 0;
    }

    public void sortBy(){
        vehiculos.sort(Comparator.comparingInt(TimeStep::getSize));
    }

    public void addTimeStep(TimeStep timeStep){
        vehiculos.add(timeStep);
        totalSpeed += timeStep.getAvgSpeed();
    }

    public int getSize(){
        return vehiculos.size();
    }

    public double avgSpeed(){
        return totalSpeed / vehiculos.size();
    }

}
