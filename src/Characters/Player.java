package Characters;

import Attributes.Health;
import States.Combat;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Player extends Unit implements IObservable {

    private Integer experience;
    private Integer level;

    protected Player(Integer experience, Integer level, String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(name, health, attackPoints, defencePoints);
        this.experience = 0;
        this.level = 1;
        List<IObserver> observers = new ArrayList<>();
    }

    public void setPosition (int x,int y){
        getPosition().setX(x);
        getPosition().setY(y);
    }

    public void levelUp() {
        while (experience > 50 * level) {
            this.experience = this.experience - (50 * this.level);
            setLevel(this.level + 1);
            notifyObservers("Level up: +" + 10 * this.level + " Health, " + 5 * this.level +" Attack, " + 2 * this.level + " Defense");
            getHealth().setHealthPool(getHealth().getHealthPool() + (10 * this.level));
            getHealth().setCurrentHealth(getHealth().getHealthPool());
            setAttackPoints(getAttackPoints() + (5 * this.level));
            setDefencePoints(getDefencePoints() + (2 * this.level));
        }
    }

    public void play(char movevement){
        if(movevement == 'w'){
            getCurrBoard().moveUp(this);
        } else if(movevement == 's'){
            getCurrBoard().moveDown(this);
        } else if(movevement == 'a'){
            getCurrBoard().moveLeft(this);
        } else if(movevement == 'd'){
            getCurrBoard().moveRight(this);
        } else if(movevement == 'e'){
            this.speacialAbility();
        }
    }

    public abstract void afterPlay();

    protected LinkedList<Enemy> getEnemiesInRange(int range) {
        return getCurrBoard().getEnemiesInRange(range);
    }

    public int getExperience(){
        return experience;
    }

    protected abstract void speacialAbility();

    public Integer getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        if(experience >= 50*this.level){
            levelUp();
        }
    }

    private void setLevel(Integer level) {
        this.level = level;
    }

    public void updateDead (){
        setIsDead(true);
    }

    public void stepOn (Unit unit){
        Combat.fight(unit,this);
    }

    public String myChar (){
        if(!getIsDead()){
            return "@";
        }
        else {
            return "X";
        }
    }

    public boolean canAttackMonster (){
        return true;
    }

}
