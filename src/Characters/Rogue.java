package Characters;

import Attributes.Health;
import Attributes.Position;

import java.util.LinkedList;
import Attributes.Health;
import Attributes.Position;


public class Rogue extends Player {

    private int cost;
    private int CurrentEnergy;
    private LinkedList<Enemy> enemies;

    public Rogue(int cost, Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints, Position position) {
        super(experience, level, name, health, attackPoints, defencePoints, position);
        this.cost = cost;
        this.CurrentEnergy = 100;
        this.enemies = getEnemiesInRange(2);
    }

    @Override
    public void play() {

    }

    @Override
    public boolean stepedOnMe(Unit unit) {
        return false;
    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public boolean Dead() {
        return false;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.CurrentEnergy = 100;
        setAttackPoints(getAttackPoints() + 3 * (getLevel() + 1));
    }

    public void gametick() {
        this.CurrentEnergy = Math.min(CurrentEnergy + 10, 100);
    }

    public boolean cast() {
        if (CurrentEnergy < cost) {
            return false;
        } else {
            CurrentEnergy = CurrentEnergy - cost;
            for (Unit enemy : enemies) {
                Health h = new Health(enemy.getHealth().getHealthPool(), enemy.getHealth().getCurrentHealth() - getAttackPoints());
                enemy.setHealth(h);
            }
            return true;
        }
    }

    public void speacialAbility(){
        for (Unit enemy : enemies) {
            Health h = new Health(enemy.getHealth().getHealthPool(), enemy.getHealth().getCurrentHealth() - getAttackPoints());
            enemy.setHealth(h);
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCurrentEnergy() {
        return CurrentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        CurrentEnergy = currentEnergy;
    }

}
