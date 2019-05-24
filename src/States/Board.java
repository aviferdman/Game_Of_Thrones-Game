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
    private Cell [] [] theBoard;
    int level;
    String pathToLevels;

    public Board (Player player, String pathToLevels){
        this.player=player;
        DemiBoard demiBoard = ReadFiles.ReadBoard(pathToLevels+"\\level1.txt",player);
        setTheBoard(demiBoard);
        this.level = 1;
        this.pathToLevels = pathToLevels;
        observers = new ArrayList<>();
        this.player.setCurrBoard(this);
        updateEnemiesRangeFromPlayer();
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Enemy> getEnemies(){
        return this.enemies;
    }

    public LinkedList<Free> getFrees(){
        return this.free;
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

    public void setTheBoard(DemiBoard demiBoard) {
        this.enemies =demiBoard.getEnemies();
        this.free=demiBoard.getFree();
        this.walls=demiBoard.getWalls();
        this.theBoard =demiBoard.getTheBoard();
        for (Enemy enemy:enemies) {
            enemy.setCurrBoard(this);
        }
    }

    public void Tick (){
        player.play('s');
        for (Enemy enemy: enemies) {
            enemy.play();
        }
        updateEnemiesRangeFromPlayer();
        if (enemies.isEmpty()){
            boardLevelUp();
        }
    }

    public boolean moveUp(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return getTheBoard()[x][y-1].stepOn(unit);
    }

    public boolean moveDown(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return getTheBoard()[x][y+1].stepOn(unit);
    }

    public boolean moveLeft(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return getTheBoard()[x-1][y].stepOn(unit);
    }

    public boolean moveRight(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getX();
        return getTheBoard()[x+1][y].stepOn(unit);
    }

    public LinkedList<Enemy> getEnemiesInRange(int range) {
        LinkedList<Enemy> returnEnemies = new LinkedList<>();
        for (Enemy enemy :getEnemies() ) {
            if(player.IsInRange(enemy,range)){
                returnEnemies.add(enemy);
            }
        }
        return returnEnemies;
    }

    public LinkedList<Cell> freeLocations (int range, Unit unit){
        LinkedList <Cell> output = new LinkedList<>();
        for (Free freeLocation: free ) {
            if (unit.IsInRange(freeLocation,range)){
                output.add(freeLocation);
            }
        }
        return output;
    }

    public void boardLevelUp (){
        if (level<4) {
            level = level + 1;
            setTheBoard(ReadFiles.ReadBoard(pathToLevels + "\\level" + level + ".txt", player));
        }
    }

    public void updateEnemiesRangeFromPlayer(){
        for (Enemy enemy: enemies) {
            if(player.IsInRange(enemy,enemy.getVisionRange())){
                enemy.setIsPlayerInRange(true);
            }
            else {
                enemy.setIsPlayerInRange(false);
            }
        }
    }

    public void mainLoop() {
        while (true) {
            notifyState();
            Tick();
            if (gameOver()) {
                notifyState();
                break;
            }
        }
    }

    public boolean gameOver (){
        return player.getIsDead();
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

    public void notifyState(){
        notifyObservers(this.toString());
        notifyObservers(player.toString());
    }

    @Override
    public String toString(){
        String output ="";
        for (int i=0;i<theBoard[0].length;i=i+1){
            for (int j=0;j<theBoard.length;j=j+1){
                output = output + theBoard[j][i].myChar();
            }
            output = output +"\n";
        }
        return output;
    }

}
