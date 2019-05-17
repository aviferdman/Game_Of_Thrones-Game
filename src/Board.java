import java.util.LinkedList;

public class Board {

    private Player player;
    LinkedList<Unit> units = new LinkedList<>();
    private LinkedList<Position> free = new LinkedList<>();
    private LinkedList<Position> walls = new LinkedList<>();
    private IRandom iRandom;
    private Cell [] [] theBoard;

    public Board (Player player, String pathToLevels, String pathToD ){
        this.player=player;
        theBoard = ReadFiles.ReadBoard(pathToLevels+"\\level1.txt",player);
        this.iRandom = iRandom.getInstance(pathToD);
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Unit> getUnits(){
        return this.units;
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUnits(LinkedList<Unit> units) {
        this.units = units;
    }

    public void Tick (){
        for (Unit unit : units) {
            unit.play();
        }
    }

    public void setBoard (String path){

    public boolean moveUp(Unit unit){
        return move(unit, "up");
    }

    public boolean moveDown(Unit unit){
        return move(unit, "down");
    }

    public boolean moveLeft(Unit unit){
        return move(unit, "left");
    }

    public boolean moveRight(Unit unit){
        return move(unit, "right");
    }

    public boolean move(Unit unit, String direction){
        return true;
    }
}
