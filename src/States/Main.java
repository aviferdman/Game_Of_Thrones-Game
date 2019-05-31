package States;

import Characters.Player;
import Random.DRandom;
import Random.IRandom;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        determinitic = args[1]!=null;
        Player player=null;
        List<Character> actions = Arrays.asList('2', 'w', 'w', 'w');
        List<Integer> numbers = Arrays.asList(0, 0, 0, 0, 0, 0);
        IRandom.setInstance(new DRandom(numbers, actions));
        System.out.println("select player");
        int chosenPlayer = Integer.parseInt(String.valueOf(IRandom.getInstance().nextChar()));
        player = ReadFiles.createPlayer(chosenPlayer);

        Board mainBoard = new Board(player,args[0]);
        mainBoard.mainLoop();
    }
}
