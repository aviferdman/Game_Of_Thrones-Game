import java.util.LinkedList;

public class Mage extends Player {

    private int SpellPower;
    private int ManaPool;
    private int CurrentMana;
    private int ManaCost;
    private int HitTimes;
    private int Range;
    private SpecialAbility Blizard;
    private SpecialAbility specialAbility;
    private LinkedList<Unit> enemies;

    public Mage(int SpellPower,int ManaPool,int ManaCast,int HitTimes,int Range, Integer experience, Integer level, SpecialAbility specialAbility, String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        super(experience, level, specialAbility,name,health, attackPoints,defencePoints, position);
        this.SpellPower = SpellPower;
        this.ManaPool = ManaPool;
        this.CurrentMana = ManaPool/4;
        this.ManaCost = ManaCast;
        this.HitTimes = HitTimes;
        this.Range = Range;
        this.specialAbility = Blizard;
    }

    @Override
    public boolean play() {
        return false;
    }

    public void levelUp(){
        this.ManaPool = this.ManaPool + (25 * this.level);
        this.CurrentMana = Math.min((this.CurrentMana + (4/this.ManaPool)),(this.ManaPool));
        this.SpellPower = this.SpellPower + (10 * this.level);
    }

    public void gametick(){
        this.CurrentMana = Math.min((this.ManaPool),(this.CurrentMana+1));
    }

    public boolean cast(){
        if(this.CurrentMana < this.ManaCost){
            System.out.println("error");
        } else {
            this.CurrentMana = this.CurrentMana - this.ManaCost;
            int hits = 0;
            while(hits <this.HitTimes){

            }
        }
    }


}
