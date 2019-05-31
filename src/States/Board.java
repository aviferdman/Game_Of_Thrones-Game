package States;

import Characters.*;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;
import Characters.GameEnemies.Monster;
import Random.IRandom;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board implements IObservable {

    private List<IObserver> observers;
    private Player player;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Monster> monsters = new LinkedList<>();
    private LinkedList<Free> free = new LinkedList<>();
    private LinkedList<Wall> walls = new LinkedList<>();
    private Cell [] [] theBoard;

    private CommandLineApp CLA;

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

    public void mainLoop() {
        this.CLA = new CommandLineApp(this);
        while (true) {
            notifyState();
            Tick();
            if (gameOver()) {
                notifyState();
                break;
            }
        }
    }

    private void Tick (){
        char c=IRandom.getInstance().nextChar();
        player.play(c);
        player.afterPlay();
        for (Enemy enemy: enemies) {
            enemy.play();
        }
        updateEnemiesRangeFromPlayer();
        if (monsters.isEmpty()){
            boardLevelUp();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Enemy> getEnemies(){
        return this.enemies;
    }

    public LinkedList<Monster> getMonsters(){
        return this.monsters;
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

    public void setCell (Cell cell, int x, int y){
        this.theBoard[x][y]=cell;
    }

    public void setUnits(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void moveUp(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        Cell c =getTheBoard()[y][x-1];
        c.stepOn(unit);
    }

    public void moveDown(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        getTheBoard()[y][x+1].stepOn(unit);
    }

    public void moveLeft(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        getTheBoard()[y-1][x].stepOn(unit);
    }

    public void moveRight(Unit unit){
        int x = unit.getPosition().getX();
        int y = unit.getPosition().getY();
        getTheBoard()[y+1][x].stepOn(unit);
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
        if(level == 4){
            notifyObservers("Game is finished. You won!");
        }
        if (level<4) {
            level = level + 1;
            setTheBoard(ReadFiles.ReadBoard(pathToLevels + "\\level" + level + ".txt", player));
            if(observers != null) {
                observers.forEach(this::register);
            }
        }
    }

    public void setTheBoard(DemiBoard demiBoard) {
        this.player=demiBoard.getPlayer();
        this.enemies =demiBoard.getEnemies();
        this.monsters=demiBoard.getMonsters();
        this.free=demiBoard.getFree();
        this.walls=demiBoard.getWalls();
        this.theBoard =demiBoard.getTheBoard();
        for (Enemy enemy:enemies) {
            enemy.setCurrBoard(this);
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

    public boolean gameOver (){
        return player.getIsDead();
    }

    @Override
    public void register(IObserver o) {
        observers.add(o);
        Combat.register(o);
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
        StringBuilder output = new StringBuilder();
        for (int i=0;i<theBoard[0].length;i=i+1){
            for (Cell[] cells : theBoard) {
                Cell c = cells[i];
                output.append(cells[i].myChar());
            }
            output.append("\n");
        }
        return output.toString();
    }
}
