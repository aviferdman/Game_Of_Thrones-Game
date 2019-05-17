import java.util.LinkedList;

public abstract class Player extends Unit {

    private Integer experience;
    private Integer level;
    private LinkedList<Unit> enemies;

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

    public abstract boolean play();

    public LinkedList<Unit> getEnemiesInRange(int range) {
        Board b = new Board(this);
        this.enemies = b.getUnits();
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

    public boolean stepedOn (Unit attacker){
        Combat.fight(attacker,this);
        return true;
    }

    public boolean canAttackMonster (){
        return true;
    }

}
