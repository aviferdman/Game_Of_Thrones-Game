package Characters.GamePlayers;

import Attributes.Health;
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
    public void afterPlay() {
        gametick();
    }

    public void levelUp() {
        super.levelUp();
        this.remaining = 0;
        this.getHealth().setHealthPool(this.getHealth().getHealthPool() + (5 * this.getLevel()));
        this.setDefencePoints(this.getDefencePoints() + this.getLevel());
        notifyObservers("+" +5 * this.getLevel()+ " Health, +" + this.getLevel() + " Defense");
    }

    private void gametick() {
        if(this.remaining > 0) {
            this.remaining = this.remaining - 1;
        }
    }

    public void speacialAbility() {
        notifyObservers(this.getName() + " cast Heal.");
        if (this.remaining == 0) {
            if (this.getDefencePoints() * 2 + this.getHealth().getCurrentHealth() > this.getHealth().getHealthPool()) {
                this.getHealth().setCurrentHealth(this.getHealth().getHealthPool());
            } else {
                this.getHealth().setCurrentHealth(this.getHealth().getCurrentHealth() + this.getDefencePoints() * 2);
            }
            this.remaining = this.cooldown;
        } else {
            notifyObservers("Cant cast spacial ability, " + this.remaining + " turns remaining.");
        }
    }

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + " Health: " +getHealth().getCurrentHealth() + "        " +" Attack damage: " + getAttackPoints() + "        " + " Defense: " +getDefencePoints() + "\n" +
                "Level: " +getLevel() + "        " + " Experience: " +getExperience() + "/" +50*this.getLevel() + "        " + " Ability cooldown: " +getCooldown() + "\n"
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
