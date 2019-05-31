package Characters.GameEnemies;

import Attributes.Health;
import Attributes.Position;
import Characters.Enemy;
import Characters.GameCells.Free;
import Characters.Player;
import Random.IRandom;
import Random.RandomGenerator;
import States.Combat;

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
        if(range(this,getCurrBoard().getPlayer())<this.getVisionRange()){
            if(isAside(getCurrBoard().getPlayer().getPosition())){
                Combat.fight(this,getCurrBoard().getPlayer());
            }
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

    public boolean isAside(Position playerPosition){
        int monsterPositionX = this.getPosition().getX();
        int monsterPositionY = this.getPosition().getY();
        int playerPositionX = playerPosition.getX();
        int playerPositionY = playerPosition.getY();
        if(monsterPositionX + 1 == playerPositionX & monsterPositionY == playerPositionY){
            return true;
        } else if(monsterPositionX - 1 == playerPositionX & monsterPositionY == playerPositionY){
            return true;
        } else if(monsterPositionY + 1 == playerPositionY & monsterPositionX == playerPositionX){
            return true;
        } else return monsterPositionY - 1 == playerPositionY & monsterPositionX == playerPositionX;
    }

    public void chasePlayer(Position playerPosition){
        int dx = this.getPosition().getX() - playerPosition.getX();
        int dy = this.getPosition().getY() - playerPosition.getY();
        if(Math.abs(dx)>Math.abs(dy)){
            if(dx>0) {
                getCurrBoard().moveLeft(this);
            } else {
                getCurrBoard().moveRight(this);
            }
        } else {
            if(dy>0){
                getCurrBoard().moveUp(this);
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
        getCurrBoard().getMonsters().remove(this);
        Free free = new Free(getPosition().getX(),getPosition().getY());
        getCurrBoard().getFrees().add(free);
        getCurrBoard().setCell(free,getPosition().getY(),getPosition().getX());
    }

    @Override
    public String myChar() {
        return ""+getTile();
    }

}
