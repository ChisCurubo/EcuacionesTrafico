package co.edu.upb;

import java.util.Comparator;
import java.util.LinkedList;

public class TimeStep {
    private LinkedList<Vehiculo> vehiculos;
    private double totalSpeed;
    private double densidad;
    private double flujo;
    private String time;

    public TimeStep(String time){
        vehiculos = new LinkedList<>();
        this.time = time;
        totalSpeed = 0;
    }

    public void addVehicle(Vehiculo newVehicle){
        vehiculos.add(newVehicle);
        totalSpeed += newVehicle.getSpeed();
    }

    public double getAvgSpeed(){
        if (getSize() == 0) return 0;
        return totalSpeed / vehiculos.size();
    }

    // Getter and setter --------------------------------------------------------
    public LinkedList<Vehiculo> getVehiclesList() {
        return vehiculos;
    }

    public int getSize(){
        return vehiculos.size();
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setTotalSpeed(double totalSpeed) {
        this.totalSpeed = totalSpeed;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public double getFlujo() {
        return flujo;
    }

    public void setFlujo(double flujo) {
        this.flujo = flujo;
    }

    public String getTime() {
        return time;
    }
}
