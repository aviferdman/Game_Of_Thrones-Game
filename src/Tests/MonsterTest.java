package Tests;

import Attributes.Health;
import Attributes.Position;
import Characters.GameEnemies.Monster;
import Characters.GamePlayers.Mage;
import Characters.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterTest {
    private final Monster M_Test = new Monster("Queen Cersei" ,'C', new Health(100,100), 10, 10, 1, 1000);
    private final Player T_Player = new Mage(1,2,3,4,5,6,1,"Test Mage",new Health(120,120),7,8);

    @Test
    public void getVisionRange() {
        assertEquals(1,M_Test.getVisionRange());
    }

    @Test
    public void updateDead() {
        M_Test.setIsDead(true);
        assertTrue(M_Test.getIsDead());
    }

    @Test
    public void myChar() {
        assertEquals('C',M_Test.getTile());
    }

    @Test
    public void chasePlayer() {
        T_Player.setPosition(2,4);
        M_Test.setPosition(2,2);
        M_Test.chasePlayer(T_Player.getPosition());
        assertEquals(new Position(2,3),M_Test.getPosition());
        T_Player.setPosition(2,5);
        M_Test.chasePlayer(T_Player.getPosition());
        assertEquals(new Position(2,4),M_Test.getPosition());
    }
}