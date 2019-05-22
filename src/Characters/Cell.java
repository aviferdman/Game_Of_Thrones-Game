package Characters;
import Attributes.Position;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell implements IObservable {
    private List<IObserver> observers;

    protected Cell(){
        observers = new ArrayList<>();
    }

    public abstract boolean stepedOnMe (Unit unit);
    public abstract Position getPosition();
    public abstract void setPosition(Position position);
    public abstract void play();

    public void register(IObserver o){
        observers.add(o);
    }

    public void notifyObservers(String message){
        observers.forEach(o -> o.onEvent(message));
    }
}
