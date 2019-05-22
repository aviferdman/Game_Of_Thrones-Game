package Characters;

import Attributes.Position;

public class DeadPlayer extends Cell {

    Position position;

    @Override
    public boolean stepedOnMe(Unit unit) {
        return false;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public void setPosition(Position position) {
        this.position=position;
    }

    @Override
    public void play() {

    }

    @Override
    public String myChar() {
        return "X";
    }
}
