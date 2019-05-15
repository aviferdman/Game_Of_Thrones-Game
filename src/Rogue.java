import java.util.LinkedList;

public class Rogue extends Player {

    private int cost;
    private int CurrentEnergy;

    public Rogue(int cost, Integer experience, Integer level, SpecialAbility specialAbility, String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        super(experience, level, specialAbility,name,health, attackPoints,defencePoints, position);
        this.cost=cost;
        this.CurrentEnergy = 100;
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.CurrentEnergy= 100;
        this.attackPoints = attackPoints + 3*(level+1);
    }

    public void gametick(){
        this.CurrentEnergy= Math.min(CurrentEnergy+10,100);
    }
    public boolean cast(){
        if (CurrentEnergy < cost){
            return false;
        }
        else {
            CurrentEnergy = CurrentEnergy- cost;
            return true;
        }
    }


}
