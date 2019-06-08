package States;

import Characters.Player;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        startGame(args);
    }

    private static void startGame(String [] args) {
        if(args.length>1) {
            determinitic = args[1] != null;
        }
        else {
            determinitic = false;
        }
        /*List<Character> actions = Arrays.asList('2', 'd', 'w', 'w');
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1, 1);
        IRandom.setInstance(new DRandom(numbers, actions));*/
        // int chosenPlayer = Integer.parseInt(String.valueOf(IRandom.getInstance().nextChar()));
        //int chosenPlayer = 1;
        Player player = CommandLineApp.choosePlayer();
        Board mainBoard = new Board(player);
        mainBoard.setTheBoard(args[0],"\\level1.txt",player);
        mainBoard.mainLoop();
    }
}

