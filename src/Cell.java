import javafx.geometry.Pos;

public abstract class Cell {

    public abstract boolean stepedOn (Unit unit);
    public abstract Position getPosition();
    public abstract void setPosition(Position position);
}
