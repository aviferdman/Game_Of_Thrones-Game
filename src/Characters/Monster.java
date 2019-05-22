package Characters;

import Attributes.Health;
import Attributes.Position;
import Random.IRandom;
import Random.RandomGenerator;
import States.Board;

public class Monster extends Enemy {

    private int visionRange;
    private Board board;

    public Monster(String name, char tile, Health health, int attackPoints, int defencePoints, int visionRange, int experienceValue, Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.visionRange = visionRange;
    }

    @Override
    public void setExperience(int experience) {

    }

    public void play(){
        RandomGenerator rg = IRandom.getInstance();
        int move = rg.nextInt(4);
        if (move == 1){
            board.moveUp(this);
        } else if(move ==2 ){
            board.moveLeft(this);
        } else if(move ==3){
            board.moveRight(this);
        } else {
            board.moveDown(this);
        }
    }

    public void setBoard(Board board){
        this.board = board;
    }

    @Override
    public boolean stepedOnMe(Unit unit) {
        return false;
    }

    @Override
    public boolean Dead() {
        return false;
    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public String myChar() {
        return null;
    }
}
