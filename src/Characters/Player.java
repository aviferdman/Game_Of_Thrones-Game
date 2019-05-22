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
    private Board board;

    public Player(Integer experience, Integer level , String name, Health health, Integer attackPoints, Integer defencePoints, Position position) {
        super(name, health, attackPoints, defencePoints, position);
        this.experience = 0;
        this.level = 1;
        this.enemies = new LinkedList<>();
    }

    public void setPosition (int x,int y){
        setPosition(x,y);
    }

    public void setBoard (Board board){
        this.board= board;
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
            board.moveUp(this);
        } else if(movevement == 's'){
            board.moveDown(this);
        } else if(movevement == 'a'){
            board.moveLeft(this);
        } else if(movevement == 'd'){
            board.moveRight(this);
        } else if(movevement == 'e'){
            this.speacialAbility();
        }
    }

    public LinkedList<Enemy> getEnemiesInRange(int range) {
        return board.getEnemiesInRange(range);
    }

    public int getExperience(){
        return experience;
    }

    public abstract void speacialAbility();

    public Integer getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience += experience;
        if(experience > 50){
            levelUp();
        }
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void updateDead (){
        //need to complete what happens when player is dead
    }

    public boolean IstepedOn (Cell cell){
       cell.stepedOnMe(this);
       return true;
    }

    public boolean StepedOnMe (Unit unit){
        Combat.fight(unit,this);
        return true;
    }

    public String myChar (){
        if(getIsDead()){
            return "@";
        }
        else {
            return "X";
        }
    }

    public boolean canAttackMonster (){
        return true;
    }

    @Override
    public String toString() {
        String output = "";

        output = getName() + "        " + getHealth().getCurrentHealth() + "        " + getAttackPoints() + "        " + getDefencePoints() + "\n" +
                getLevel() + "        " + getExperience() + "/50" + "        ";

        return output;
    }
}
