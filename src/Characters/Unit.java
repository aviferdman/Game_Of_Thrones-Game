package Characters;

import Attributes.Health;
import Attributes.Position;
import States.Board;

public abstract class Unit extends Cell{
    private final String name;
    private Health health;
    private Integer attackPoints;
    private Integer defencePoints;
    private Position position = new Position(-1,-1);
    private boolean isDead;
    private Board currBoard;

    Unit(String name, Health health, Integer attackPoints, Integer defencePoints){
        this.name = name;
        this.health=health;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.isDead = false;
    }

    public void setCurrBoard(Board currBoard){
        this.currBoard = currBoard;
    }

    public Board getCurrBoard(){
        return this.currBoard;
    }

    public abstract void setExperience(int experience);

    public boolean getIsDead(){
        return this.isDead;
    }

    public void setIsDead(boolean newStatus){
        this.isDead = newStatus;
    }

    public String getName() {
        return name;
    }

    public Health getHealth() {
        return health;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public Integer getDefencePoints() {
        return defencePoints;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract int getExperience ();

    public abstract void updateDead();

    public void setPosition(int x,int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    protected void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefencePoints(Integer defencePoints) {
        this.defencePoints = defencePoints;
    }

    public void setHealth(Health health) {
        if (health.getCurrentHealth()<= health.getHealthPool()) {
            this.health = health;
        }
    }

    public boolean IsInRange(Cell cell,int range) {
        if (cell==null) {
            return false;
        }
        int x = position.getX();
        int y = position.getY();

        int a = cell.getPosition().getX();
        int b = cell.getPosition().getY();

        return (Math.sqrt(Math.pow((b - y), 2) + Math.pow((a - x), 2))) < range;
    }

    protected int range(Enemy enemy, Player player){
        int Px = player.getPosition().getX();
        int Py = player.getPosition().getY();
        int Qx = enemy.getPosition().getX();
        int Qy = enemy.getPosition().getY();
        return (int)(Math.sqrt(Math.pow((Px-Qx),2) + Math.pow((Py-Qy),2)));
    }

    protected abstract boolean canAttackMonster();

}
