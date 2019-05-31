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
        /*determinitic = args[1]!=null;*/
        determinitic = false;
        Player player=null;
        /*List<Character> actions = Arrays.asList('2', 'd', 'w', 'w');
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1, 1);
        IRandom.setInstance(new DRandom(numbers, actions));*/
       // int chosenPlayer = Integer.parseInt(String.valueOf(IRandom.getInstance().nextChar()));
        int chosenPlayer =1;
        player = ReadFiles.createPlayer(chosenPlayer);

        Board mainBoard = new Board(player,args[0]);
        mainBoard.mainLoop();
    }
}
