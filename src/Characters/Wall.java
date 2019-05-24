package Characters;

import Attributes.Position;

public class Wall extends Cell {

    Position position;

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

    @Override
    public String myChar() {
        return null;
    }

    public boolean stepOn (Unit unit){return true;}
}
