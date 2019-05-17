public class Wall extends Cell {

    Position position;

    public Wall (int x,int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean stepedOnMe (Unit unit){
        return false;
    }

    public boolean play() {
        return false;
    }
}
