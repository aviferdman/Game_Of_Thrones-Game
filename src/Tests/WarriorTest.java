package Tests;

import Attributes.Health;
import Characters.GamePlayers.Warrior;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {
    private final Warrior W_Test = new Warrior(4, 0, 1, "The Hound", new Health(400, 400), 20, 6);

    @Test
    public void getCooldown() {
        assertEquals(4,W_Test.getCooldown());
    }

    @Test
    public void getRemaining() {
        assertEquals(0,W_Test.getRemaining());
    }
}