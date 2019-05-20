package States;

import Characters.Player;
import States.Board;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static boolean determinitic;
    public static void main(String[] args){
        determinitic = Arrays.stream(args).anyMatch(s -> s.equals("-D"));
        Player SelectedPlayer;
        LinkedList<Player> players;
        Board board = new Board(SelectedPlayer,args[0]);

        players = playersInit();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select player:");
        int selectedPlayer = -1;

        selectedPlayer = scanner.nextInt();

        switch (selectedPlayer){
            case 1:{

                break;
            }
            case 2:{

                break;
            }
            case 3:{

                break;
            }
            case 4:{

                break;
            }
            case 5:{


                break;
            }
            case 6:{

                break;
            }
        }

    }

    private static LinkedList<Player> playersInit(){
        LinkedList<Player> players = new LinkedList<>();
        return players;
    }
}
