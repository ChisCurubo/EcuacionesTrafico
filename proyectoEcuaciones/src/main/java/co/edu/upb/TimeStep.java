package co.edu.upb;

import java.util.LinkedList;

public class TimeStep {
    double tamanoMapa = 250;
    private LinkedList<Vehiculo> vehiculos;
    private double totalSpeed;
    private double densidad;
    private double velocidad;
    private double flujo;
    private String time;

    public TimeStep(String time){
        vehiculos = new LinkedList<>();
        this.time = time;
        totalSpeed = 0;
        densidad = 0;
        flujo = 0;
        velocidad = 0;
    }

    public void addVehicle(Vehiculo newVehicle){
        vehiculos.add(newVehicle);
        totalSpeed += newVehicle.getSpeed();
    }

    public double getAvgSpeed(){
        if (getSize() == 0) return 0;
        velocidad = totalSpeed / vehiculos.size();
        return velocidad;
    }

    public double getAvgDensidad(){
        if (getSize() == 0) return 0;
        densidad=  (getSize()/ tamanoMapa);
        return densidad;
    }

    public double gettAvgFlujo(){
        if (getSize() == 0) return 0;
        flujo = (float) (densidad * getAvgSpeed());
        return flujo;
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
