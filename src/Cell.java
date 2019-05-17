import javafx.geometry.Pos;

public abstract class Cell {

    public abstract boolean stepedOnMe (Unit unit);
    public abstract Position getPosition();
    public abstract void setPosition(Position position);
}
