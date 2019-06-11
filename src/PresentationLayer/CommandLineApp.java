package PresentationLayer;

import Attributes.Health;
import Characters.GamePlayers.Mage;
import Characters.GamePlayers.Rogue;
import Characters.GamePlayers.Warrior;
import Characters.Player;
import Random.IRandom;
import States.Board;
import observer.IObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLineApp implements IObserver {

    public CommandLineApp(Board board){
        board.register(this);
    }

    @Override
    public void onEvent(String message) {
        System.out.println(message);
    }

    public static Player choosePlayer() {
        List<Player> players;
        System.out.println("Choose player: ");
        players = new ArrayList<>();
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
        Player player = players.get(Character.getNumericValue(IRandom.getInstance().nextChar()) - 1);
        System.out.println("You have selected:" + "\n" + player);
        System.out.println("use w/s/a/d to move." +"\n" + "Use 'e' for special ability or 'q' to pass");
        return player;
    }
}
