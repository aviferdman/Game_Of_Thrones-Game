package Characters;

import Attributes.Health;
import Attributes.Position;
import Random.IRandom;
import Random.RandomGenerator;
import States.Board;
import States.Combat;

public class Monster extends Enemy {

    private int visionRange;
    private boolean isPlayerInRange;
    private Board board;

    public Monster(String name, char tile, Health health, int attackPoints, int defencePoints, int visionRange, int experienceValue, Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.visionRange = visionRange;
    }

    @Override
    public void setExperience(int experience) {

    }

    @Override
    public void setIsPlayerInRange(boolean isPlayerInRange) {
        this.isPlayerInRange = isPlayerInRange;
    }

    @Override
    public int getVisionRange() {
        return this.visionRange;
    }

    public void play(){
        if(isPlayerInRange){
            chasePlayer(board.getPlayer().getPosition());
        }
        else {
            RandomGenerator rg = IRandom.getInstance();
            int move = rg.nextInt(4);
            if (move == 1) {
                board.moveUp(this);
            } else if (move == 2) {
                board.moveLeft(this);
            } else if (move == 3) {
                board.moveRight(this);
            } else {
                board.moveDown(this);
            }
        }
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public boolean getIsPlayerInRange(){
        return this.isPlayerInRange;
    }

    public void setPlayerInRange(boolean playerInRange){
        this.isPlayerInRange= playerInRange;
    }

    @Override
    public boolean stepedOnMe(Unit unit) {
        if(unit.canAttackMonster()){
            Combat.fight(unit,this);
        }
        return true;
    }

    @Override
    public String myChar() {
        return ""+getTile();
    }

    public void chasePlayer(Position position){
        if(getPosition().getX()!=position.getX()){
            if(getPosition().getX()>position.getX()){
                board.moveLeft(this);
            }
            else {
                board.moveRight(this);
            }
        }
        else {
            if(getPosition().getY()>position.getY()){
                board.moveUp(this);
            }
            else {
                board.moveDown(this);
            }
        }
    }
}
