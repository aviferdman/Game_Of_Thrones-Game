public abstract class Enemy extends Unit{

    private Integer experienceValue;
    private char tile;
    public Enemy (String name,char tile,Health health,int attackPoints,int defencePoints,int experienceValue,Position position){
        super(name,health,attackPoints,defencePoints,position);
        this.experienceValue = experienceValue;
        this.tile=tile;
    }

    public boolean play(){return false;}

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }

    public char getTile() {
        return tile;
    }

    public void setTile(char tile) {
        this.tile = tile;
    }
}
