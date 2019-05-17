package Characters;
import Attributes.Position;

public abstract class Cell {

    public abstract boolean stepedOnMe (Unit unit);
    public abstract Position getPosition();
    public abstract void setPosition(Position position);
    public abstract boolean play();
}
