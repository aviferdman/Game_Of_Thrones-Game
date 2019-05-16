public class Monster extends Enemy {

    private int visionRange;

    public Monster(String name, char tile, Health health, int attackPoints, int defencePoints, int visionRange, int experienceValue, Position position) {
        super(name, tile, health, attackPoints, defencePoints, experienceValue, position);
        this.visionRange = visionRange;
    }
}
