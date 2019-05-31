package Characters.GamePlayers;

import Attributes.Health;
import Attributes.Position;

import java.util.LinkedList;
import Attributes.Health;
import Attributes.Position;
import Characters.Enemy;
import Characters.Player;
import Characters.Unit;
import States.Combat;


public class Rogue extends Player {

    private int cost;
    private int CurrentEnergy;
    private int range;
    private LinkedList<Enemy> enemies;

    public Rogue(int cost, Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(experience, level, name, health, attackPoints, defencePoints);
        this.cost = cost;
        this.CurrentEnergy = 100;
        this.range = 2;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.CurrentEnergy = 100;
        setAttackPoints(getAttackPoints() + 3 * (getLevel() + 1));
        notifyObservers("+" +3 * (getLevel() + 1)+ " attack points ");
    }

    @Override
    public void afterPlay() {
        gametick();
    }

    public void gametick() {
        this.CurrentEnergy = Math.min(CurrentEnergy + 10, 100);
    }

    public void cast() {
        this.enemies = getEnemiesInRange(this.range);
        if (CurrentEnergy < cost) {
        } else {
            CurrentEnergy = CurrentEnergy - cost;
            for (Enemy enemy : enemies) {
                Combat.fight(this,enemy,this.getAttackPoints());
            }
        }
    }

    public void speacialAbility(){
        notifyObservers(this.getName() + " cast Fan of Knives.");
        for (Enemy enemy : getEnemiesInRange(this.range)) {
            Combat.fightWithNoDefense(this,enemy,getAttackPoints());
        }
    }

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + " Health: " +getHealth().getCurrentHealth() + "        " + " Attack damage: " +getAttackPoints() + "        " + " Defence: " +getDefencePoints() + "\n" +
                "Level: " +getLevel() + "        " + " Experience: " + getExperience() +"/"+ 50*this.getLevel() + "        " + " Energy: " +getCurrentEnergy() + "/100" ;
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
