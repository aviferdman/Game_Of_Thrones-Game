package Tests;

import Attributes.Health;
import Characters.GamePlayers.Mage;

import static org.junit.Assert.*;

public class MageTest {
    private final Mage M_TEST = new Mage(1,2,3,4,5,6,1,"Test Mage",new Health(1,1),7,8);

    @org.junit.Test
    public void getManaCost() {
        assertEquals(3,M_TEST.getManaCost());
    }

    @org.junit.Test
    public void getHitTimes() {
        assertEquals(4,M_TEST.getHitTimes());
    }

    @org.junit.Test
    public void getRange() {
        assertEquals(5,M_TEST.getRange());
    }


}