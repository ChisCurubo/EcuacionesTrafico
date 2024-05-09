package co.edu.upb;

import java.util.Comparator;
import java.util.LinkedList;

public class Simulacion {
    LinkedList<TimeStep> vehiculos;
    double totalSpeed;
    double totalDensidad;
    double totalFlujo;

    public Simulacion() {
        vehiculos = new LinkedList<>();
        totalSpeed = 0;
        totalDensidad= 0;
        totalFlujo =0;
    }

    public void sortBy(){
        vehiculos.sort(Comparator.comparingInt(TimeStep::getSize));
    }

    public void addTimeStep(TimeStep timeStep){
        vehiculos.add(timeStep);
        totalSpeed += timeStep.getAvgSpeed();
        totalDensidad += timeStep.getAvgDensidad();
        totalFlujo += timeStep.gettAvgFlujo();
    }

    public LinkedList<TimeStep> getVehiculos() {
        return vehiculos;
    }

    public int getSize(){
        return vehiculos.size();
    }


    public double avgSpeed(){
        return totalSpeed / vehiculos.size();
    }
    public double avgDensidad(){
        return totalDensidad / vehiculos.size();
    }
    public double avgFlujo(){
        return totalFlujo / vehiculos.size();
    }

}
