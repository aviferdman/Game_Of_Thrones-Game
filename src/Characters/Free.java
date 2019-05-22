package Characters;
import Attributes.Position;


public class Free extends Cell{

    Position position;
    public Free (int x,int y){
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

    public boolean stepedOnMe (Unit unit){
        Position temp = unit.getPosition();
        unit.setPosition(position.getX(),position.getY());
        setPosition(temp);
        return true;
    }

    public void play() {
    }

    @Override
    public String myChar() {
        return ".";
    }
}
