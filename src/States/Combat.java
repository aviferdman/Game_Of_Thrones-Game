package States;

import Attributes.Health;
import Characters.Unit;
import Random.IRandom;
import Random.RandomGenerator;

public class Combat {

    public static void fight (Unit attacker, Unit defender){

        RandomGenerator random = IRandom.getInstance();

        int attackPoints = random.nextInt(attacker.getAttackPoints());
        int defencePoints = random.nextInt(defender.getDefencePoints());

        if(attackPoints - defencePoints > 0){
            defender.getHealth().setCurrentHealth(defender.getHealth().getCurrentHealth()-attackPoints);
            if(defender.getHealth().getCurrentHealth() <= 0){
                defender.setIsDead(true);
                int experience = defender.getexerienceValue();
                if(experience > 0) {
                    attacker.setExperience(defender.getexerienceValue());
                }
            }
        }
    }
}
