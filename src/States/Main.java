package States;

import Characters.Player;

import java.util.Scanner;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        determinitic = args[1]!=null;
        Player player=null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("select player");
        int choosenPlayer = scanner.nextInt();
        Player currPlayer = ReadFiles.createPlayer(choosenPlayer);


        Board mainBoard = new Board(player,args[0]);
        mainBoard.mainLoop();

    }

}
