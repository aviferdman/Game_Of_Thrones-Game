package Characters;
import Attributes.Health;
import Attributes.Position;
import Random.IRandom;
import Random.RandomGenerator;
import States.Board;
import States.Combat;

public abstract class Enemy extends Unit {

    private Integer experienceValue;
    private char tile;


    public Enemy (String name, char tile, Health health, int attackPoints, int defencePoints, int experienceValue){
        super(name,health,attackPoints,defencePoints);
        this.experienceValue = experienceValue;
        this.tile=tile;
    }


    public int getExperience() {
        return experienceValue;
    }

    public void setExperience(int experienceValue) {
        this.experienceValue = experienceValue;
    }

    public abstract void setIsPlayerInRange (boolean isPlayerInRange);

    public char getTile() {
        return tile;
    }

    @Override
    public String toString() {
        String output="";

        output+= this.getName() + "        " + "Health: " +this.getHealth().getCurrentHealth() + "        " + "Attack damage: " +this.getAttackPoints() + "        " + "Defense: " +this.getDefencePoints();

        return output;
    }

    public abstract int getVisionRange();

    public void setTile(char tile) {
        this.tile = tile;
    }

    public boolean stepOn (Unit unit){
        if (unit.canAttackMonster()){
            Combat.fight(unit,this);
        }
        return true;
    }


    public abstract void updateDead ();

    public boolean canAttackMonster (){
        return false;
    }

    public abstract void play();
}
