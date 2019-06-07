package States;

import Characters.Unit;
import Random.IRandom;
import Random.RandomGenerator;
import observer.IObserver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Combat {

    private static final List<IObserver> observers = new ArrayList<>();
    private static final RandomGenerator random = IRandom.getInstance();

    public static void fight (Unit attacker, Unit defender){
        combat(attacker,defender,random.nextInt(attacker.getAttackPoints()),random.nextInt(defender.getDefencePoints()));
    }

    public static void fight (Unit attacker, Unit defender,int attackPoints){
        combat(attacker,defender,attackPoints,random.nextInt(defender.getDefencePoints()));
    }

    public static void combat(Unit attacker, Unit defender, int attackPoints, int defensePoints){
        notifyObservers(attacker.getName() + " engaged in battle with " + defender.getName());
        notifyObservers(attacker.getName() + " rolled " + attackPoints + " attack points");
        notifyObservers(defender.getName() + " rolled " + defensePoints + " defense points");
        if(attackPoints - defensePoints > 0){
            notifyObservers(attacker.getName() + " hit " + defender.getName() + " for " +(attackPoints - defensePoints) + " damage");
            defender.getHealth().setCurrentHealth(defender.getHealth().getCurrentHealth()-attackPoints);
            if(defender.getHealth().getCurrentHealth() <= 0){
                defender.setIsDead(true);
                defender.updateDead();
                int experience = defender.getExperience();
                if(experience > 0) {
                    attacker.setExperience(experience+attacker.getExperience());
                    notifyObservers(defender.getName() + " died. " + attacker.getName() + " gained " + defender.getExperience() + " experience!" );
                } else {
                    notifyObservers(defender.getName() + " died." + "\n" + "You Lost.");
                }
            }
        }
    }

    static void register(IObserver o) {
        observers.add(o);
    }

    private static void notifyObservers(String message) {
        observers.forEach(o -> o.onEvent(message));
    }
}

