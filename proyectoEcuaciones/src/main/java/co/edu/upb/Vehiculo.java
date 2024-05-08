package co.edu.upb;


public class Vehiculo {
    private String id;
    private double cordX;
    private double cordY;
    private double angle;
    private String type;
    private double speed;
    private double pos;
    private String lane;
    private double slope;

    public Vehiculo(String id, double cordX, double cordY, double angle, String type, double speed, double pos, String lane, double slope) {
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

    // Getter and setters -----------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCordX() {
        return cordX;
    }

    public void setCordX(double cordX) {
        this.cordX = cordX;
    }

    public double getCordY() {
        return cordY;
    }

    public void setCordY(double cordY) {
        this.cordY = cordY;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }
}
