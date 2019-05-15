import java.util.LinkedList;

public abstract class Player extends  Unit {
    Integer experience;
    Integer level;
    SpecialAbility specialAbility;

    public Player(Integer experience, Integer level, SpecialAbility specialAbility, String name, Health health, Integer attackPoints, Integer defencePoints, Position position) {
        super(name, health, attackPoints, defencePoints, position);
        this.experience = 0;
        this.level = 1;
        this.specialAbility = specialAbility;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }

    public SpecialAbility getSpecialAbility() {
        return specialAbility;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setSpecialAbility(SpecialAbility specialAbility) {
        this.specialAbility = specialAbility;
    }

    public void levelUp() {
        while (experience > 50 * level) {
            experience = experience - (50 * level);
            level = level + 1;
            health.setHealthPool(getHealth().getHealthPool() + (10 * level));
            health.setCurrentHealth(health.getHealthPool());
            attackPoints = attackPoints + (5 * level);
            defencePoints = defencePoints + (2 * level);
        }
    }

    public abstract boolean play();

    public LinkedList<Unit> getEnemies(int range) {
        LinkedList<Unit> enemies = Board.getUnits;
        for (Unit Enemy: enemies) {
            if (!Enemy.IsInRange(range)){
                enemies.remove(Enemy);
            }
        }
        return enemies;
    }
}
