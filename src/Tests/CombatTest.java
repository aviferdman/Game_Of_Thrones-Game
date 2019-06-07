package Tests;

import Attributes.Health;
import Characters.GameEnemies.Monster;
import Characters.GamePlayers.Mage;
import Characters.Player;
import States.Combat;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatTest {
    private final Monster T_Monster = new Monster("Queen Cersei" ,'C', new Health(100,100), 10, 10, 1, 1000);
    private final Player T_Player = new Mage(1,2,3,4,5,6,1,"Test Mage",new Health(120,120),7,8);

    @Test
    public void combat() {
        Combat.combat(T_Player,T_Monster,T_Player.getAttackPoints(),T_Monster.getDefencePoints());
        assertEquals(100,T_Monster.getHealth().getCurrentHealth().intValue());
        Combat.combat(T_Monster,T_Player,T_Monster.getAttackPoints(),T_Player.getDefencePoints());
        assertEquals(118,T_Player.getHealth().getCurrentHealth().intValue());
    }
}