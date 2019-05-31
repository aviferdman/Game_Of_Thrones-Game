package Characters.GamePlayers;

import Attributes.Health;
import Attributes.Position;

import java.util.LinkedList;
import Attributes.Health;
import Attributes.Position;
import Characters.Enemy;
import Characters.Player;
import Characters.Unit;


public class Rogue extends Player {

    private int cost;
    private int CurrentEnergy;
    private LinkedList<Enemy> enemies;

    public Rogue(int cost, Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(experience, level, name, health, attackPoints, defencePoints);
        this.cost = cost;
        this.CurrentEnergy = 100;
        this.enemies = getEnemiesInRange(2);
    }

    @Override
    public String myChar() {
        return null;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.CurrentEnergy = 100;
        setAttackPoints(getAttackPoints() + 3 * (getLevel() + 1));
    }

    @Override
    public void afterPlay() {
        cast();
        gametick();
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

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + " Health: " +getHealth().getCurrentHealth() + "        " + " Attack damage: " +getAttackPoints() + "        " + " Defence: " +getDefencePoints() + "\n" +
                " Level: " +getLevel() + "        " + getExperience() + 50*this.getLevel() + "        " + " Energy: " +getCurrentEnergy() + "/100" ;
        return output;
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
