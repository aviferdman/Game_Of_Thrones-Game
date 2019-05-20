package States;

import Characters.*;
import Random.IRandom;
import Random.RandomGenerator;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board implements IObservable {
    private List<IObserver> observers;
    private Player player;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Free> free = new LinkedList<>();
    private LinkedList<Wall> walls = new LinkedList<>();
    private RandomGenerator iRandom;
    private Cell [] [] theBoard;
    int level;
    String pathToLevels;

    public Board (Player player, String pathToLevels){
        this.player=player;
        theBoard = ReadFiles.ReadBoard(pathToLevels+"\\level1.txt",player);
        this.iRandom = IRandom.getInstance();
        level = 1;
        pathToLevels = pathToLevels;
        observers = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Enemy> getEnemies(){
        return this.enemies;
    }

    public Cell[][] getTheBoard() {
        return theBoard;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUnits(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setTheBoard(Cell[][] theBoard) {
        this.theBoard = theBoard;
    }

    public void Tick (){
        for (int i=0;i<theBoard[0].length; i=i+1){
            for (int j=0;j<theBoard[0].length; j=j+1){
                theBoard[i][j].play();
            }
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

    public boolean updateDead(Enemy enemy){
        enemies.remove(enemy);
        int x = enemy.getPosition().getX();
        int y = enemy.getPosition().getY();
        Free f = new Free(x, y);
        free.add(f);
        theBoard[x][y]= f;
        if (enemies.isEmpty()){
            boardLevelUp();
        }
        return true;
    }

    public boolean updateDead(Player player){
        endGame();
        return true;
    }

    public void boardLevelUp (){
        if (level<4) {
            level = level + 1;
            setTheBoard(ReadFiles.ReadBoard(pathToLevels + "\\level" + level + ".txt", player));
        }
    }

    /*public void mainLoop(){
        while(true){
            notifyState()
            Tick();
            if(gameOver()){
                ...
            }
        }
    }*/

    public void endGame (){
        //need to change the player char to X
    }

    @Override
    public void register(IObserver o) {
        observers.add(o);
        for (Cell[] cells : theBoard) {
            for (Cell cell : cells) {
                cell.register(o);
            }
        }
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(o -> o.onEvent(message));
    }

    public void notifState(){
        notifyObservers(this.toString());
        notifyObservers(player.toString());
    }
}
