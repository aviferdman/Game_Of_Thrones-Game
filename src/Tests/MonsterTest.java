package Tests;

import Attributes.Health;
import Attributes.Position;
import Characters.Cell;
import Characters.GameCells.Free;
import Characters.GameEnemies.Monster;
import Characters.GamePlayers.Mage;
import Characters.Player;
import States.Board;
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
        Cell [] [] cells = new Cell[10][10];
        for (int i=0;i<10;i=i+1){
            for (int j=0;j<10;j=j+1){
                cells[i][j]= new Free(i,j);
            }
        }
        T_Player.setPosition(2,4);
        M_Test.setPosition(2,2);
        Board testBoard = new Board(T_Player);
        testBoard.setCellsArray(cells);
        testBoard.setCell(T_Player,4,2);
        testBoard.setCell(M_Test,2,2);
        M_Test.setCurrBoard(testBoard);
        M_Test.chasePlayer(T_Player.getPosition());
        assertTrue(M_Test.getPosition().beLike(new Position(3,2)));
    }
}