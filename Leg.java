import java.io.Serializable;

public class Leg implements Serializable {
    private String Code;
    private  boolean Available;
    private int X;
    private int Y;


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Leg(String code, boolean available, int x, int y) {
        this.Code = code;
        this.Available = available;
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return "{" + "Code='" + Code +  ", Available='" + Available +  ", X=" + X + ", Y=" + Y + "}"+ "\n";
    }







}