package Characters;

import Attributes.Health;
import Attributes.Position;

public class Monster extends Enemy {

    private int visionRange;

    public Monster(String name, char tile, Health health, int attackPoints, int defencePoints, int visionRange, int experienceValue, Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.visionRange = visionRange;
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
}
