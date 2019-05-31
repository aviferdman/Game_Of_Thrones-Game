package States;

import States.Board;
import observer.IObserver;

public class CommandLineApp implements IObserver {

    public CommandLineApp(Board board){
        board.register(this);
    }

    @Override
    public void onEvent(String message) {
        System.out.println(message);
    }
}
