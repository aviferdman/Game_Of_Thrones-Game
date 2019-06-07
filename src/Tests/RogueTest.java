package Tests;

import Attributes.Health;
import Characters.GamePlayers.Rogue;
import org.junit.Test;

import static org.junit.Assert.*;

public class RogueTest {
    final private Rogue R_Test = new Rogue(20, 0, 1, "Arya Stark", new Health(150, 150), 40, 2);

    @Test
    public void getCost() {
        assertEquals(20,R_Test.getCost());
    }

    @Test
    public void getCurrentEnergy() {
        assertEquals(100,R_Test.getCurrentEnergy());
    }

    @Test
    public void getRange() {
        assertEquals(2,R_Test.getRange());
    }
}