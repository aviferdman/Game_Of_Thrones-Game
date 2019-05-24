package States;

import Characters.Player;

import java.util.Scanner;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        args = new String[2];
        args[0]="C:\\Users\\ASUS\\HW3";
        determinitic = args[1]!=null;
        Player player=null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("select player");
        int choosenPlayer = scanner.nextInt();
        player = ReadFiles.createPlayer(choosenPlayer);

        Board mainBoard = new Board(player,args[0]);
        mainBoard.mainLoop();

    }

}
