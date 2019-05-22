package States;

import Attributes.Health;
import Characters.Unit;

public class Combat {

    public static void fight (Unit attacker, Unit defender){
        int attackPoints = (int)(Math.random()*(attacker.getAttackPoints()));
        int defencePoints = (int)(Math.random()*(defender.getDefencePoints()));

        if(attackPoints - defencePoints > 0){
            defender.getHealth().setCurrentHealth(defender.getHealth().getCurrentHealth()-attackPoints);
            if(defender.getHealth().getCurrentHealth() <= 0){
                defender.Dead();
            }
        }
    }
}
