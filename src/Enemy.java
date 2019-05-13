public class Enemy extends Unit{
    Integer experienceValue;
    char tile;
    public Enemy (Integer experienceValue, char tile, String name, Health health, Integer attackPoints, Integer defencePoints, Position position){
        super(name,health,attackPoints,defencePoints,position);
        this.experienceValue = experienceValue;
        this.tile=tile;
    }
}
