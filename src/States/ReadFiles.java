package States;

import Characters.*;
import Attributes.Health;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;
import Characters.GameEnemies.Monster;
import Characters.GameEnemies.Trap;
import Characters.GamePlayers.Mage;
import Characters.GamePlayers.Rogue;
import Characters.GamePlayers.Warrior;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadFiles {

    public static DemiBoard ReadBoard (String path, Player player){
        int width=0;
        int length=0;
        DemiBoard demiBoard = new DemiBoard();
        LinkedList<Free> frees = new LinkedList<>();
        LinkedList<Wall> walls = new LinkedList<>();
        LinkedList<Enemy> enemies = new LinkedList<>();
        File file = new File(path);
        Scanner sc = null;
        try
        {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            width=(line.length());
            for (int i=0;i<line.length();i=i+1) {
                char c = line.charAt(i);
                if(c=='@'){
                    player.setPosition(lineNumber,i);
                }
                if(c=='s'){
                    Enemy enemy = new Monster("Lannister Solider" ,'s',new Health(80,80), 8, 3, 3, 25);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='k'){
                    Enemy enemy = new Monster("Lannister Knight", 'k', new Health(200,200), 14, 8, 4, 50);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='q'){
                    Enemy enemy = new Monster("Queen’s Guard", 'q', new Health(400,400), 20, 15, 5, 100);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='z'){
                    Enemy enemy = new Monster("Wright", 'z', new Health(600,600), 30, 15, 3, 100);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='b'){
                    Enemy enemy = new Monster("Bear-Wright", 'b', new Health(1000,1000), 75, 30, 4, 250);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='g'){
                    Enemy enemy = new Monster("Giant-Wright", 'g', new Health(1500,1500), 100, 40, 5, 500);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='w'){
                    Enemy enemy = new Monster("White Walker", 'w', new Health(2000,2000), 150, 50, 6, 1000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='M'){
                    Enemy enemy = new Monster("The Mountain", 'M', new Health(1000,1000), 60, 25, 6, 500);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='C'){
                    Enemy enemy = new Monster("Queen Cersei" ,'C', new Health(100,100), 10, 10, 1, 1000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='K'){
                    Enemy enemy = new Monster("Night’s King", 'K', new Health(5000,5000), 300, 150, 8, 5000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='B'){
                    Enemy enemy = new Trap ("Bonus Characters.Trap", 'B', new Health(1,1), 1, 1, 250, 5, 6,2);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='Q'){
                    Enemy enemy = new Trap ("Queen’s Characters.Trap", 'Q', new Health(250,250), 50, 10, 100, 4, 10,4);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='D'){
                    Enemy enemy = new Trap("Death Characters.Trap", 'D', new Health(500,500), 100, 20, 250, 6, 10,3);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='#'){
                    Wall wall = new Wall (lineNumber,i);
                    walls.add(wall);
                }
                if(c=='.'){
                    Free free = new Free (lineNumber,i);
                    frees.add(free);
                }
            }
            lineNumber=lineNumber+1;
        }
        length=(lineNumber);
        Cell [] [] theBoard = new Cell[width][length];
        theBoard[player.getPosition().getY()][player.getPosition().getX()]=player;
        for (Enemy enemy : enemies) {
            theBoard [enemy.getPosition().getY()] [enemy.getPosition().getX()] = enemy;
        }
        for (Free free : frees){
            theBoard [free.getPosition().getY()] [free.getPosition().getX()] = free;
        }
        for (Wall wall : walls){
            theBoard [wall.getPosition().getY()] [wall.getPosition().getX()] = wall;
        }
        theBoard[player.getPosition().getY()][player.getPosition().getX()]=player;
        demiBoard.setPlayer(player);
        demiBoard.setEnemies(enemies);
        demiBoard.setFree(frees);
        demiBoard.setWalls(walls);
        demiBoard.setTheBoard(theBoard);

        return demiBoard;
    }

    public static Player createPlayer(int choosenPlayer) {
        if (choosenPlayer == 1) {
            Player JonSnow = new Warrior(6, 0, 1, "Jon Snow", new Health(300, 300), 30, 4);
            return JonSnow;
        } else if (choosenPlayer == 2) {
            Player TheHound = new Warrior(4, 0, 1, "The Hound", new Health(400, 400), 20, 6);
            return TheHound;
        } else if (choosenPlayer == 3) {
            Player Melisandre = new Mage(40, 300, 30, 5, 6, 0, 1, "Melisandre", new Health(160, 160), 10, 1);
            return Melisandre;
        } else if (choosenPlayer == 4) {
            Player ThorosOfMyr = new Mage(15, 150, 50, 3, 3, 0, 1, "Thoros of Myr", new Health(250, 250), 25, 3);
            return ThorosOfMyr;
        } else if (choosenPlayer == 5) {
            Player AryaStark = new Rogue(20, 0, 1, "Arya Stark", new Health(150, 150), 40, 2);
            return AryaStark;
        } else {
            Player Bronn = new Rogue(60, 0, 1, "Bronn", new Health(250, 250), 35, 3);
            return Bronn;
        }
    }

}
