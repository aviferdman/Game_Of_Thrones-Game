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

    public Cell[][] getTheBoard() {
        return theBoard;
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

    public boolean moveUp(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return unit.IstepedOn(getTheBoard()[x][y-1]);
    }

    public boolean moveDown(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return unit.IstepedOn(getTheBoard()[x][y+1]);
    }

    public boolean moveLeft(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return unit.IstepedOn(getTheBoard()[x-1][y]);
    }

    public boolean moveRight(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return unit.IstepedOn(getTheBoard()[x+1][y]);
    }
}
