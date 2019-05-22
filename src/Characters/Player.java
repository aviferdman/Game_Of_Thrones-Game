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

    public Player(Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints, Position position) {
        super(name, health, attackPoints, defencePoints, position);
        this.experience = 0;
        this.level = 1;
        this.enemies = new LinkedList<>();
    }

    public void setPosition (int x,int y){
        setPosition(x,y);
    }

    public void levelUp() {
        while (experience > 50 * level) {
            this.experience = this.experience - (50 * this.level);
            this.level = this.level + 1;
            getHealth().setHealthPool(getHealth().getHealthPool() + (10 * this.level));
            getHealth().setCurrentHealth(getHealth().getHealthPool());
            setAttackPoints(getAttackPoints() + (5 * this.level));
            setDefencePoints(getDefencePoints() + (2 * this.level));
        }
    }

    public abstract void play();

    public LinkedList<Enemy> getEnemiesInRange(int range) {
        Board b = new Board(this);
        this.enemies = b.getEnemies();
        for (Unit Enemy: enemies) {
            if (!this.IsInRange(Enemy,range)){
                enemies.remove(Enemy);
            }
        }
        return enemies;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }


    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean IstepedOn (Cell cell){
       cell.stepedOnMe(this);
       return true;
    }
    public boolean StepedOnMe (Unit unit){
        Combat.fight(unit,this);
        return true;
    }

    public boolean canAttackMonster (){
        return true;
    }

}
