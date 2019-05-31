package Characters.GamePlayers;

import Attributes.Health;
import Attributes.Position;
import Characters.Player;

public class Warrior extends Player {

    private int cooldown;
    private int remaining;

    public Warrior(int cooldown, Integer experience, Integer level, String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(experience, level, name, health, attackPoints, defencePoints);
        this.remaining = 0;
        this.cooldown = cooldown;
    }

    @Override
    public String myChar() {
        return null;
    }

    @Override
    public void afterPlay() {
        cast();
        gametick();
    }

    public void levelUp() {
        this.remaining = 0;
        this.getHealth().setHealthPool(this.getHealth().getHealthPool() + (5 * this.getLevel()));
        this.setDefencePoints(this.getDefencePoints() + this.getLevel());
    }

    public void gametick() {
        this.remaining = this.remaining - 1;
    }

    public boolean cast() {
        if (remaining > 0) {
            return false;
        } else {
            remaining = cooldown;
            getHealth().setCurrentHealth(Math.min(getHealth().getCurrentHealth() + 2 * getDefencePoints(), getHealth().getHealthPool()));
            return true;
        }
    }

    public void speacialAbility() {
        if (this.remaining == 0) {
            if (this.getDefencePoints() * 2 + this.getHealth().getCurrentHealth() > this.getHealth().getHealthPool()) {
                this.getHealth().setCurrentHealth(this.getHealth().getHealthPool());
            } else {
                this.getHealth().setCurrentHealth(this.getHealth().getCurrentHealth() + this.getDefencePoints() * 2);
            }
            this.remaining = this.cooldown;
        }
    }

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + " Health: " +getHealth().getCurrentHealth() + "        " +" Attack damage: " + getAttackPoints() + "        " + " Defense: " +getDefencePoints() + "\n" +
                " Level: " +getLevel() + "        " + " Experience: " +getExperience() + 50*this.getLevel() + "        " + " Ability cooldown: " +getCooldown() + "\n"
        + "Remaining : " + getRemaining();

        return output;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

}
