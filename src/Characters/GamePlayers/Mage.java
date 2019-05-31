package Characters.GamePlayers;

import Attributes.Health;
import Attributes.Position;
import Characters.Enemy;
import Characters.Player;

import java.util.LinkedList;

public class Mage extends Player {

    private int SpellPower;
    private int ManaPool;
    private int CurrentMana;
    private int ManaCost;
    private int HitTimes;
    private int Range;
    private LinkedList<Enemy> enemies;

    public Mage(int SpellPower, int ManaPool, int ManaCast, int HitTimes, int Range, Integer experience, Integer level, String name, Health health, Integer attackPoints, Integer defencePoints) {
        super(experience, level, name, health, attackPoints, defencePoints);
        this.SpellPower = SpellPower;
        this.ManaPool = ManaPool;
        this.CurrentMana = ManaPool / 4;
        this.ManaCost = ManaCast;
        this.HitTimes = HitTimes;
        this.Range = Range;
        this.enemies = getEnemiesInRange(this.Range);
    }


    @Override
    public String myChar() {
        return null;
    }

    public void levelUp() {
        this.ManaPool = this.ManaPool + (25 * this.getLevel());
        this.CurrentMana = Math.min((this.CurrentMana + (4 / this.ManaPool)), (this.ManaPool));
        this.SpellPower = this.SpellPower + (10 * this.getLevel());
    }

    public void gametick() {
        this.CurrentMana = Math.min((this.ManaPool), (this.CurrentMana + 1));
    }

    public boolean cast() {
        if (this.CurrentMana < this.ManaCost) {
            return false;
        } else {
            this.CurrentMana = this.CurrentMana - this.ManaCost;
            int hits = 0;
            while (hits < this.HitTimes & !enemies.isEmpty() ) {
                hitRandomEnemy();
                this.HitTimes++;
            }
            return true;
        }
    }

    public void speacialAbility() {
        hitRandomEnemy();
    }

    public void hitRandomEnemy(){
        int enemyIndex = (int)(Math.random() * enemies.toArray().length);
        Enemy currEnemy = enemies.get(enemyIndex);
        Health healthAfterAttack = new Health(currEnemy.getHealth().getHealthPool(),this.SpellPower);
        currEnemy.setHealth(healthAfterAttack);
    }

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + " Health: " + getHealth().getCurrentHealth() + "        " + " Attack damage: " +getAttackPoints() + "        " + " Defense: " +getDefencePoints() + "\n" +
                " Level: " +getLevel() + "        " + " Experience: " + getExperience() + 50*this.getLevel() + "        "  + " SpellPower: " + getSpellPower() + "        " + " Mana : " +getCurrentMana() + "/" + getManaPool();  ;

        return output;
    }

    @Override
    public void afterPlay() {
        cast();
        gametick();
    }

    public int getSpellPower() {
        return SpellPower;
    }

    public void setSpellPower(int spellPower) {
        SpellPower = spellPower;
    }

    public int getManaPool() {
        return ManaPool;
    }

    public void setManaPool(int manaPool) {
        ManaPool = manaPool;
    }

    public int getCurrentMana() {
        return CurrentMana;
    }

    public void setCurrentMana(int currentMana) {
        CurrentMana = currentMana;
    }

    public int getManaCost() {
        return ManaCost;
    }

    public void setManaCost(int manaCost) {
        ManaCost = manaCost;
    }

    public int getHitTimes() {
        return HitTimes;
    }

    public void setHitTimes(int hitTimes) {
        HitTimes = hitTimes;
    }

    public int getRange() {
        return Range;
    }

    public void setRange(int range) {
        Range = range;
    }

}
