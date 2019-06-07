package Tests;

import Attributes.Position;
import Characters.GameCells.Free;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeTest {
    private final Free F_Test = new Free(4,10);
    private final Position P_Test = new Position(4,10);

    @Test
    public void getPosition() {
        assertEquals(P_Test.getX(),F_Test.getPosition().getX());
        assertEquals(P_Test.getY(),F_Test.getPosition().getY());
    }
}