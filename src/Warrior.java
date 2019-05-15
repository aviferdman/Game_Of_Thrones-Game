public class Warrior extends Player {


    private int cooldown;
    private int remaining;

    public Warrior(int cooldown, Integer experience, Integer level, SpecialAbility specialAbility, String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        super(experience, level, specialAbility,name,health, attackPoints,defencePoints, position);
        this.remaining=0;
        this.cooldown = cooldown;
    }

    @Override
    public boolean play() {
        return false;
    }

    public void gametick(){
        remaining= remaining-1;
    }

    public boolean cast(){
        if (remaining > 0){
            return false;
        }
        else {
            remaining = cooldown;
            health.currentHealth = Math.min(health.getCurrentHealth()+ 2* getDefencePoints(), health.getHealthPool() );
            return true;
        }
    }
}
