import States.Board;
import observer.IObserver;

public class CommandLineApp implements IObserver {
    Board board;

    public CommandLineApp(Board board){
        this.board = board;
        board.register(this);
    }

    @Override
    public void onEvent(String message) {
        System.out.println(message);
    }
}
