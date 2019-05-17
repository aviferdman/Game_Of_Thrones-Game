public class Free extends Cell{
    Position position;
    public Free (int x,int y){
        position = new Position(x,y);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean stepedOn (Unit unit){
        Position temp = unit.getPosition();
        unit.setPosition(position.getX(),position.getY());
        setPosition(temp);
        return true;
    }
}
