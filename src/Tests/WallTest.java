package Tests;

import Attributes.Position;
import Characters.GameCells.Wall;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {
    private final Wall T_Wall = new Wall(10,1);

    @Test
    public void getPosition() {
        assertEquals(new Position(10,1).getX(),T_Wall.getPosition().getX());
        assertEquals(new Position(10,1).getY(),T_Wall.getPosition().getY());
    }
}