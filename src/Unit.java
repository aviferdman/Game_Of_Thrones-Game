public abstract class Unit {
    String name;
    Health health;
    Integer attackPoints;
    Integer defencePoints;
    Position position;
    public Unit(String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        this.name = name;
        this.health=health;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.position = position;
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

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefencePoints(Integer defencePoints) {
        this.defencePoints = defencePoints;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean play();

}
