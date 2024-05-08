package co.edu.upb;


public class Vehiculo {
    String id;
    Double cordX;
    Double cordY;
    Double angle;
    String type;
    Double speed;
    Double pos;
    String lane;
    Double slope;

    public Vehiculo(String id, Double cordX, Double cordY, Double angle, String type, Double speed, Double pos, String lane, Double slope) {
        this.id = id;
        this.cordX = cordX;
        this.cordY = cordY;
        this.angle = angle;
        this.type = type;
        this.speed = speed;
        this.pos = pos;
        this.lane = lane;
        this.slope = slope;
    }



}
