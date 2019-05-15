public class Health {

    private Integer healthPool;
    private Integer currentHealth;

    public Health (Integer healthPool, Integer currentHealth){
        this.healthPool = healthPool;
        this.currentHealth = currentHealth;
    }

    public Integer getCurrentHealth() {
        return this.currentHealth;
    }

    public Integer getHealthPool() {
        return this.healthPool;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setHealthPool(Integer healthPool) {
        this.healthPool = healthPool;
    }
}
