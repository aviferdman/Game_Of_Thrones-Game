package Characters.GameEnemies;

import Attributes.Health;
import Attributes.Position;
import Characters.Cell;
import Characters.Enemy;
import Characters.GameCells.Free;
import Characters.Player;
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


    public Trap(String name, char tile, Health health, int attackPoints, int defencePoints, int experienceValue, int range, int respwan, int visibility) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue);
        this.realocationRange = range;
        this.relocationTime = respwan;
        this.visibilityTime = visibility;
        this.isVisible = true;
        this.ticksCount = 0;
    }

    @Override
    public void setExperience(int experience) {

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
    public void play() {
        Player player = this.currBoard.getPlayer();

        if(this.ticksCount == this.relocationTime){
            this.ticksCount = 0;
            trapRelocation();
        } else {
            this.ticksCount++;
            if(range(this,player)<2){
                Combat.fight(this,player);
            }
        }

        if(this.ticksCount < this.visibilityTime){
            setVisible(true);
        } else {
            setVisible(false);
        }
    }

    private void trapRelocation(){
        LinkedList<Cell> freePositions = currBoard.freeLocations(this.realocationRange,this);
        RandomGenerator random = IRandom.getInstance();
        int index = random.nextInt(freePositions.size());
        Cell free = freePositions.get(index);
        int positionX = free.getPosition().getX();
        int positionY = free.getPosition().getY();
        Position temp = new Position(getPosition().getX(),getPosition().getY());

        this.setPosition(positionX,positionY);
        free.setPosition(temp.getX(),temp.getY());

        getCurrBoard().setCell(free,free.getPosition().getY(),free.getPosition().getX());
        getCurrBoard().setCell(this,getPosition().getY(),getPosition().getX());
    }

    public void updateDead (){
        currBoard.getEnemies().remove(this);
        Free free = new Free(this.getPosition().getX(),this.getPosition().getY());
        currBoard.getFrees().add(free);
        currBoard.setCell(free,free.getPosition().getX(),free.getPosition().getY());
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

    private void setVisible(boolean visible) {
        isVisible = visible;
    }
}
