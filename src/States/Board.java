package States;

import Characters.*;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;
import Characters.GameEnemies.Monster;
import DataLayer.ReadFiles;
import PresentationLayer.CommandLineApp;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board implements IObservable {

    private final List<IObserver> observers;
    private Player player;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Monster> monsters = new LinkedList<>();
    private LinkedList<Free> free = new LinkedList<>();
    private Cell [] [] theBoard;
    private boolean playerWonTheGame;

    private int level;
    private String pathToLevels;

    public Board (Player player){
        this.player=player;
        this.level = 1;
        this.pathToLevels = pathToLevels;
        observers = new ArrayList<>();
        this.player.setCurrBoard(this);
        updateEnemiesRangeFromPlayer();
        playerWonTheGame = false;
    }

    public void mainLoop() {
        CommandLineApp CLA = new CommandLineApp(this);
        while (true) {
            notifyState();
            Tick();
            if (gameOver()) {
                notifyState();
                break;
            }
            if (playerWonTheGame){
                PlayerWon();
                notifyState();
                break;
            }
        }
    }

    private void Tick (){
        player.play();
        for (Enemy enemy: enemies) {
            enemy.play();
        }
        updateEnemiesRangeFromPlayer();
        if (enemies.isEmpty()){
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

    private Cell[][] getTheBoard() {
        return theBoard;
    }

    public void setCellsArray (Cell [][] array){
        this.theBoard = array;
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

    private void boardLevelUp(){
        level = level + 1;
        if(ReadFiles.IsFileExists(pathToLevels+ "\\level" + level + ".txt")){
            setTheBoard(pathToLevels, "\\level" + level + ".txt", player);
        }
        else {
            playerWonTheGame = true;
        }
    }

    public void setTheBoard(String path,String levelPath,Player player) {
        this.pathToLevels = path;
        DemiBoard demiBoard = ReadFiles.ReadBoard((path + levelPath), player);
        this.player=demiBoard.getPlayer();
        this.enemies =demiBoard.getEnemies();
        this.monsters=demiBoard.getMonsters();
        this.free=demiBoard.getFree();
        LinkedList<Wall> walls = demiBoard.getWalls();
        this.theBoard =demiBoard.getTheBoard();
        for (Enemy enemy:enemies) {
            enemy.setCurrBoard(this);
        }
    }

    private void updateEnemiesRangeFromPlayer(){
        for (Enemy enemy: enemies) {
            if(player.IsInRange(enemy,enemy.getVisionRange())){
                enemy.setIsPlayerInRange(true);
            }
            else {
                enemy.setIsPlayerInRange(false);
            }
        }
    }

    private boolean gameOver(){
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

    private void notifyState(){
        notifyObservers(this.toString());
        notifyObservers(player.toString());
    }

    private void PlayerWon(){
        notifyObservers("~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~\n" +
                "!+~YOU WON THE GAME~+!\n" +
                "\"THE WINTER IS COMING\"\n" +
                "~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~~");
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
