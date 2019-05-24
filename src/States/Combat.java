package States;


import Attributes.Health;
import Characters.Unit;
import Random.IRandom;
import Random.RandomGenerator;

public class Combat {

    public static String fight (Unit attacker, Unit defender){

        String output= "";

        RandomGenerator random = IRandom.getInstance();

        int attackPoints = random.nextInt(attacker.getAttackPoints());
        output+= attacker.getName() + " rolled " + attackPoints + " attack points" + "\n";
        int defencePoints = random.nextInt(defender.getDefencePoints());
        output+= defender.getName() + " rolled " + defencePoints + " defense points" + "\n";

        if(attackPoints - defencePoints > 0){
            output+= attacker.getName() + " hit " + defender.getName() + " for " +attackPoints + " damage";
            defender.getHealth().setCurrentHealth(defender.getHealth().getCurrentHealth()-attackPoints);
            if(defender.getHealth().getCurrentHealth() <= 0){
                defender.setIsDead(true);
                defender.updateDead();
                int experience = defender.getExperience();
                if(experience > 0) {
                    attacker.setExperience(experience+attacker.getExperience());
                }
            }
        }
        return output;
    }
}
