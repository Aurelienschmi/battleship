package bo;
import java.util.ArrayList;
import java.util.List;

public class Boat {
    private String name;
    private String id;
    private int lenght;
    private int x;
    private int y;
    private int direction;


    public Boat(String name, String id, int lenght, int x, int y, int direction ){
        this.name = name;
        this.id = id;
        this.lenght = lenght;
        this.x = x;
        this.y = y;
        this.direction = direction;

    }

    public String getId() {
        return id;
    }

    public int getLenght() {
        return lenght;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
