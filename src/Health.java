public class Health {
    Integer healthPool;
    Integer currentHealth;
    public Health (Integer healthPool, Integer currentHealth){
        this.healthPool = healthPool;
        this.currentHealth = currentHealth;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public Integer getHealthPool() {
        return healthPool;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setHealthPool(Integer healthPool) {
        this.healthPool = healthPool;
    }
}
