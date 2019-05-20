package observer;

public interface IObservable {
    void register(IObserver o);
    void notifyObservers(String message);
}
