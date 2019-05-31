package States;

import Attributes.Health;
import Characters.GamePlayers.Mage;
import Characters.GamePlayers.Rogue;
import Characters.GamePlayers.Warrior;
import Characters.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static boolean determinitic;
    private static ArrayList<Player> players;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        /*determinitic = args[1]!=null;*/
        determinitic = false;
        Player player = null;
        /*List<Character> actions = Arrays.asList('2', 'd', 'w', 'w');
        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 1, 1);
        IRandom.setInstance(new DRandom(numbers, actions));*/
        // int chosenPlayer = Integer.parseInt(String.valueOf(IRandom.getInstance().nextChar()));
        //int chosenPlayer = 1;
        choosePlayer();
        player = players.get(sc.nextInt()-1);
        System.out.println("You have selected:" + "\n" + player);
        System.out.println("use w/s/a/d to move." +"\n" + "Use 'e' for special ability or 'q' to pass");
        Board mainBoard = new Board(player, args[0]);
        mainBoard.mainLoop();
    }

    private static void choosePlayer() {
        System.out.println("Choose player: ");
        players = new ArrayList<Player>();
        players.add(new Warrior(6, 0, 1, "Jon Snow", new Health(300, 300), 30, 4));
        players.add(new Warrior(4, 0, 1, "The Hound", new Health(400, 400), 20, 6));
        players.add(new Mage(40, 300, 30, 5, 6, 0, 1, "Melisandre", new Health(160, 160), 10, 1));
        players.add(new Mage(15, 150, 50, 3, 3, 0, 1, "Thoros of Myr", new Health(250, 250), 25, 3));
        players.add(new Rogue(20, 0, 1, "Arya Stark", new Health(150, 150), 40, 2));
        players.add(new Rogue(60, 0, 1, "Bronn", new Health(250, 250), 35, 3));
        int counter = 1;
        for(Player player : players){
            System.out.println(counter +"." + player.toString());
            counter++;
        }
    }

}

