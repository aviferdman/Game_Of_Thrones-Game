package States;

import Attributes.Health;
import Characters.Unit;
import Random.IRandom;
import Random.RandomGenerator;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Combat {

    private static List<IObserver> observers = new ArrayList<>();

    public static void fight (Unit attacker, Unit defender){
        RandomGenerator random = IRandom.getInstance();

        notifyObservers(attacker.getName() + " engaged in battle with " + defender.getName() + "\n");
        int attackPoints = random.nextInt(attacker.getAttackPoints());
        notifyObservers(attacker.getName() + " rolled " + attackPoints + " attack points" + "\n");
        int defencePoints = random.nextInt(defender.getDefencePoints());
        notifyObservers(defender.getName() + " rolled " + defencePoints + " defense points" + "\n");

        if(attackPoints - defencePoints > 0){
            notifyObservers(attacker.getName() + " hit " + defender.getName() + " for " +attackPoints + " damage");
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
    }

    public static void register(IObserver o) {
        observers.add(o);
    }

    public static void notifyObservers(String message) {
        observers.forEach(o -> o.onEvent(message));
    }
}

