package Characters;

import Attributes.Health;
import Attributes.Position;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Unit extends Cell{
    private String name;
    private Health health;
    private Integer attackPoints;
    private Integer defencePoints;
    private Position position;

    public Unit(String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        this.name = name;
        this.health=health;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Health getHealth() {
        return health;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public Integer getDefencePoints() {
        return defencePoints;
    }

    public Position getPosition() {
        return position;
    }

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefencePoints(Integer defencePoints) {
        this.defencePoints = defencePoints;
    }

    public void setHealth(Health health) {
        if (health.getCurrentHealth()<= health.getHealthPool()) {
            this.health = health;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int x,int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public abstract void play();

    public boolean IsInRange(Unit enemy,int range) {
        if (enemy==null) {
            return false;
        }
        int x = position.getX();
        int y = position.getY();

        int a = enemy.getPosition().getX();
        int b = enemy.getPosition().getY();

        if ((Math.sqrt((b-y)^2 + (a-x)^2))<range){
            return true;
        }
        else {
            return false;
        }
    }

    public abstract boolean IstepedOn (Cell cell);

    public abstract boolean stepedOnMe (Unit unit);

    public abstract boolean canAttackMonster ();

    public abstract boolean Dead();
}
