public class Position {
    Integer x;
    Integer y;
    public Position (){
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

    public void setPosition(int x,int y){
        setX(x);
        setY(y);
    }
}
