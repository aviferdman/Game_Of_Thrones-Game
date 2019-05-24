package States;

import Characters.*;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;

import java.util.LinkedList;

public class DemiBoard {

    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Free> free = new LinkedList<>();
    private LinkedList<Wall> walls = new LinkedList<>();
    private Cell[] [] theBoard;

    public Cell[][] getTheBoard() {
        return theBoard;
    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
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

    public void setFree(LinkedList<Free> free) {
        this.free = free;
    }

    public void setWalls(LinkedList<Wall> walls) {
        this.walls = walls;
    }
}
