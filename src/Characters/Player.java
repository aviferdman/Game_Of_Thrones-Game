package Characters;

import Attributes.Health;
import Attributes.Position;
import States.Board;
import States.Combat;

import java.util.LinkedList;

public abstract class Player extends Unit {

    private Integer experience;
    private Integer level;
    private LinkedList<Enemy> enemies;

    public Player(Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(name, health, attackPoints, defencePoints);
        this.experience = 0;
        this.level = 1;
        this.enemies = new LinkedList<>();
    }

    public void setPosition (int x,int y){
        getPosition().setX(x);
        getPosition().setY(y);
    }

    public void levelUp() {
        while (experience > 50 * level) {
            this.experience = this.experience - (50 * this.level);
            setLevel(this.level + 1);
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

    public LinkedList<Enemy> getEnemiesInRange(int range) {
        return getCurrBoard().getEnemiesInRange(range);
    }

    public int getExperience(){
        return experience;
    }

    public abstract void speacialAbility();

    public Integer getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        if(experience > 50*this.level){
            levelUp();
        }
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void updateDead (){
        setIsDead(true);
    }

    public String stepOn (Unit unit){
        String s="";
        Combat.fight(unit,this);
        s=s+""+unit.getName()+""+"engaged in battle with"+this.getName();
        return s;
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
