package Characters;

import Attributes.Health;
import Attributes.Position;
import Random.IRandom;
import Random.RandomGenerator;
import States.Board;
import States.Combat;

import java.util.LinkedList;

public class Trap extends Enemy {

    private int realocationRange;
    private int relocationTime;
    private int visibilityTime;
    private int ticksCount;
    private boolean isVisible;
    private Board currBoard;


    public Trap(String name, char tile, Health health, int attackPoints, int defencePoints, int experienceValue, int range, int respwan, int visibility , Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.realocationRange = range;
        this.relocationTime = respwan;
        this.visibilityTime = visibility;
        this.isVisible = true;
        this.ticksCount = 0;
    }



    @Override
    public void setExperience(int experience) {

    }

    public boolean stepedOnMe(Unit unit) {
        if(unit.canAttackMonster()){
            Combat.fight(unit,this);
        }
        return true;
    }


    @Override
    public String myChar() {
        if(isVisible){
            return "" + this.getTile();
        } else {
            return ".";
        }
    }

    @Override
    public void setIsPlayerInRange(boolean isPlayerInRange) {

    }

    @Override
    public int getVisionRange() {
        return -1;
    }

    @Override
    public void updateDead() {
    }

    @Override
    public void play() {
        Player player;
        if(this.ticksCount >= this.visibilityTime){
            setVisible(false);
        } else {
            setVisible(true);
        }
        if(this.ticksCount == this.relocationTime){
            trapRelocation();
            this.ticksCount = 0;
        } else {
            this.ticksCount++;
            player = this.currBoard.getPlayer();
            if(this.IsInRange(player,this.realocationRange)){
                Combat.fight(this,player);
            }
        }

    }

    public void trapRelocation(){
        LinkedList<Cell> freePositions = currBoard.freeLocations(this.realocationRange,this);
        RandomGenerator random = IRandom.getInstance();
        int index = random.nextInt(freePositions.size());
        int postionX = freePositions.get(index).getPosition().getX();
        int postionY = freePositions.get(index).getPosition().getY();
        this.setPosition(postionX,postionY);
    }

    public void setCurrBoard(Board currBoard){
        this.currBoard = currBoard;
    }

    public int getRealocationRange() {
        return realocationRange;
    }

    public void setRealocationRange(int realocationRange) {
        this.realocationRange = realocationRange;
    }

    public int getRelocationTime() {
        return relocationTime;
    }

    public void setRelocationTime(int relocationTime) {
        this.relocationTime = relocationTime;
    }

    public int getVisibilityTime() {
        return visibilityTime;
    }

    public void setVisibilityTime(int visibilityTime) {
        this.visibilityTime = visibilityTime;
    }

    public int getTicksCount() {
        return ticksCount;
    }

    public void setTicksCount(int ticksCount) {
        this.ticksCount = ticksCount;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
