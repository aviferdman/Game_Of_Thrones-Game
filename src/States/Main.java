package States;

import Characters.Player;
import PresentationLayer.CommandLineApp;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        startGame(args);
    }

    private static void startGame(String [] args) {
        determinitic = args.length > 1;
        Player player = CommandLineApp.choosePlayer();
        Board mainBoard = new Board(player);
        mainBoard.setTheBoard(args[0],"/level1.txt",player);
        mainBoard.mainLoop();
    }
}

