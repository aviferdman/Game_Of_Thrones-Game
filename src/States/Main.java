package States;

import Characters.Player;

public class Main {

    public static boolean determinitic;

    public static void main(String[] args) {
        determinitic = args[1]!=null;
        Player player=null;



        Board mainBoard = new Board(player,args[0]);
        mainBoard.mainLoop();

    }

}
