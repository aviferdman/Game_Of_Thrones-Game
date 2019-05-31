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
    private static RandomGenerator random = IRandom.getInstance();

    public static void fight (Unit attacker, Unit defender){
        combat(attacker,defender,random.nextInt(attacker.getAttackPoints()),random.nextInt(defender.getDefencePoints()));
    }

    public static void fightWithNoDefense (Unit attacker, Unit defender,int attackPoints){
        combat(attacker,defender,attackPoints,0);
    }

    public static void fight (Unit attacker, Unit defender,int attackPoints){
        int defencePoints = random.nextInt(defender.getDefencePoints());
        combat(attacker,defender,attackPoints,defencePoints);
    }

    public static void combat(Unit attacker, Unit defender, int attackPoints,int defensePoints){
        notifyObservers(attacker.getName() + " engaged in battle with " + defender.getName() + "\n");
        notifyObservers(attacker.getName() + " rolled " + attackPoints + " attack points" + "\n");
        notifyObservers(defender.getName() + " rolled " + defensePoints + " defense points" + "\n");
        if(attackPoints - defensePoints > 0){
            notifyObservers(attacker.getName() + " hit " + defender.getName() + " for " +attackPoints + " damage");
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

    public static void register(IObserver o) {
        observers.add(o);
    }

    public static void notifyObservers(String message) {
        observers.forEach(o -> o.onEvent(message));
    }
}

