package Characters.GameCells;
import Attributes.Position;
import Characters.Cell;
import Characters.Unit;


public class Free extends Cell {

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


    public void play() {
    }

    public String stepOn (Unit unit){
        Position myPos = getPosition();
        Position unitPos = unit.getPosition();
        Position temp = myPos;
        setPosition(unitPos.getX(),unitPos.getY());
        unit.setPosition(temp.getX(),temp.getY());
        return "";
    }

    @Override
    public String myChar() {
        return ".";
    }
}
