package States;

import Characters.*;
import Attributes.Health;
import Characters.GameCells.Free;
import Characters.GameCells.Wall;
import Characters.GameEnemies.Monster;
import Characters.GameEnemies.Trap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class ReadFiles {

    public static DemiBoard ReadBoard (String path, Player player){
        int width=0;
        int length=0;
        DemiBoard demiBoard = new DemiBoard();
        LinkedList<Free> frees = new LinkedList<>();
        LinkedList<Wall> walls = new LinkedList<>();
        LinkedList<Enemy> enemies = new LinkedList<>();
        LinkedList<Monster> monsters = new LinkedList<>();
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

        assert sc != null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            width=(line.length());
            for (int i=0;i<line.length();i=i+1) {
                char c = line.charAt(i);
                if(c=='@'){
                    player.setPosition(lineNumber,i);
                }
                if(c=='s'){
                    Monster enemy = new Monster("Lannister Solider" ,'s',new Health(80,80), 8, 3, 3, 25);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='k'){
                    Monster enemy = new Monster("Lannister Knight", 'k', new Health(200,200), 14, 8, 4, 50);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='q'){
                    Monster enemy = new Monster("Queen’s Guard", 'q', new Health(400,400), 20, 15, 5, 100);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='z'){
                    Monster enemy = new Monster("Wright", 'z', new Health(600,600), 30, 15, 3, 100);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='b'){
                    Monster enemy = new Monster("Bear-Wright", 'b', new Health(1000,1000), 75, 30, 4, 250);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='g'){
                    Monster enemy = new Monster("Giant-Wright", 'g', new Health(1500,1500), 100, 40, 5, 500);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='w'){
                    Monster enemy = new Monster("White Walker", 'w', new Health(2000,2000), 150, 50, 6, 1000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='M'){
                    Monster enemy = new Monster("The Mountain", 'M', new Health(1000,1000), 60, 25, 6, 500);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='C'){
                    Monster enemy = new Monster("Queen Cersei" ,'C', new Health(100,100), 10, 10, 1, 1000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='K'){
                    Monster enemy = new Monster("Night’s King", 'K', new Health(5000,5000), 300, 150, 8, 5000);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                    monsters.add(enemy);
                }
                if(c=='B'){
                    Trap enemy = new Trap ("Bonus Trap", 'B', new Health(1,1), 1, 1, 250, 5, 6,2);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='Q'){
                    Trap enemy = new Trap ("Queen’s Trap", 'Q', new Health(250,250), 50, 10, 100, 4, 10,4);
                    enemy.setPosition(lineNumber,i);
                    enemies.add(enemy);
                }
                if(c=='D'){
                    Trap enemy = new Trap("Death Trap", 'D', new Health(500,500), 100, 20, 250, 6, 10,3);
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
        demiBoard.setMonsters(monsters);
        demiBoard.setFree(frees);
        demiBoard.setWalls(walls);
        demiBoard.setTheBoard(theBoard);

        return demiBoard;
    }

}
