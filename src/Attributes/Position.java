package Attributes;

public class Position {

    private Integer x;
    private Integer y;

    public Position (int x, int y){
        this.x =x;
        this.y=y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }


    public boolean beLike(Position p){
        return (getX()==p.getX()&&getY()==p.getY());
    }

}

