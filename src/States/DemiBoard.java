package States;

import Characters.*;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;
import Characters.GameEnemies.Monster;

import java.util.LinkedList;

public class DemiBoard {

    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Monster> monsters = new LinkedList<>();
    private LinkedList<Free> free = new LinkedList<>();
    private LinkedList<Wall> walls = new LinkedList<>();
    private Player player;
    private Cell[] [] theBoard;


    public Cell[][] getTheBoard() {
        return theBoard;
    }

    public Player getPlayer (){
        return player;
    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }

    public LinkedList<Monster> getMonsters() {
        return monsters;
    }

    public LinkedList<Free> getFree() {
        return free;
    }

    public LinkedList<Wall> getWalls() {
        return walls;
    }

    public void setTheBoard(Cell[][] theBoard) {
        this.theBoard = theBoard;
    }

    public void setEnemies(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setMonsters(LinkedList<Monster> monsters){
        this.monsters = monsters;
    }

    public void setFree(LinkedList<Free> free) {
        this.free = free;
    }

    public void setWalls(LinkedList<Wall> walls) {
        this.walls = walls;
    }

    public void setPlayer (Player player){
        this.player=player;
    }
}
