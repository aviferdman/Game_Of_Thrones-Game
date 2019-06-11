package Tests;

import Attributes.Health;
import Characters.GameEnemies.Trap;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrapTest {
    private final Trap T_Trap = new Trap("Death Trap", 'D', new Health(500,500), 100, 20, 250, 6, 10,3);

    @Test
    public void getRelocationTime() {
        assertEquals(10,T_Trap.getRelocationTime());
    }

    @Test
    public void getTicksCount() {
        assertEquals(0,T_Trap.getTicksCount());
    }

}