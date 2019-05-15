import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class Main {

    public static void main(String[] args){

        Player SelectedPlayer;
        LinkedList<Player> players;

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
