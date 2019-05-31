package Characters.GameCells;

import Attributes.Position;
import Characters.Cell;
import Characters.Unit;

public class Wall extends Cell {

    private Position position;

    public Wall (int x,int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(int x, int y) {

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void play() {
    }

    public String myChar() {
        return "#";
    }

    public void stepOn (Unit unit){}
}
