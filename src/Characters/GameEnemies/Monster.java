package Characters.GameEnemies;

import Attributes.Health;
import Attributes.Position;
import Characters.Enemy;
import Characters.GameCells.Free;
import Random.IRandom;
import Random.RandomGenerator;

public class Monster extends Enemy {

    private int visionRange;
    private boolean isPlayerInRange;

    public Monster(String name, char tile, Health health, int attackPoints, int defencePoints, int visionRange, int experienceValue) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue);
        this.visionRange = visionRange;
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
            chasePlayer(getCurrBoard().getPlayer().getPosition());
        }
        else {
            RandomGenerator rg = IRandom.getInstance();
            int move = rg.nextInt(4);
            if (move == 1) {
                getCurrBoard().moveUp(this);
            } else if (move == 2) {
                getCurrBoard().moveLeft(this);
            } else if (move == 3) {
                getCurrBoard().moveRight(this);
            } else {
                getCurrBoard().moveDown(this);
            }
        }
    }

    public boolean getIsPlayerInRange(){
        return this.isPlayerInRange;
    }

    public void setPlayerInRange(boolean playerInRange){
        this.isPlayerInRange= playerInRange;
    }

    public void updateDead (){
        getCurrBoard().getEnemies().remove(this);
        Free free = new Free(getPosition().getX(),getPosition().getY());
        getCurrBoard().getFrees().add(free);
    }

    @Override
    public String myChar() {
        return ""+getTile();
    }

    public void chasePlayer(Position position){
        if(getPosition().getX()!=position.getX()){
            if(getPosition().getX()>position.getX()){
                getCurrBoard().moveUp(this);
            }
            else {
                getCurrBoard().moveDown(this);
            }
        }
        else {
            if(getPosition().getY()>position.getY()){
                getCurrBoard().moveLeft(this);
            }
            else {
                getCurrBoard().moveRight(this);
            }
        }
    }
}
