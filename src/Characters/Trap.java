package Characters;

import Attributes.Health;
import Attributes.Position;

public class Trap extends Enemy {

    private int realocationRange;
    private int relocationTime;
    private int visibilityTime;
    private int ticksCount;

    public Trap(String name, char tile, Health health, int attackPoints, int defencePoints, int experienceValue, int range, int respwan, int visibility , Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.realocationRange = range;
        this.relocationTime = respwan;
        this.visibilityTime = visibility;
        this.ticksCount = 0;
    }

    @Override
    public void setExperience(int experience) {

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

    @Override
    public void setIsPlayerInRange(boolean isPlayerInRange) {

    }

    @Override
    public int getVisionRange() {
        return 0;
    }

    @Override
    public void play() {

    }
}
