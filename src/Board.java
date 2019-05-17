import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class Board {

    private int width;
    private int length;
    private Player player;
    LinkedList<Unit> units = new LinkedList<>();
    private LinkedList<Position> free = new LinkedList<>();
    private LinkedList<Position> walls = new LinkedList<>();
    private IRandom iRandom;

    public Board (Player player, String pathToLevels, String pathToD ){
        this.player=player;
        setBoard(pathToLevels+"\\level1.txt");
        this.iRandom = iRandom.getInstance(pathToD);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Unit> getUnits(){
        return this.units;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setUnits(LinkedList<Unit> units) {
        this.units = units;
    }

    public void Tick (){
        for (Unit unit : units) {
            unit.play();
        }
    }

    public void setBoard (String path){
        File file =
                new File(path);
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
            for (int i=0;i<line.length();i=i+1) {
                char c = line.charAt(i);
                if(c=='@'){
                    player.setPosition(lineNumber,i);
                }
                if(c=='s'){
                    Unit monster = new Monster ("Lannister Solider" ,'s',new Health(80,80), 8, 3, 3, 25,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='k'){
                    Unit monster = new Monster ("Lannister Knight", 'k', new Health(200,200), 14, 8, 4, 50,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='q'){
                    Unit monster = new Monster ("Queen’s Guard", 'q', new Health(400,400), 20, 15, 5, 100,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='z'){
                    Unit monster = new Monster ("Wright", 'z', new Health(600,600), 30, 15, 3, 100,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='b'){
                    Unit monster = new Monster ("Bear-Wright", 'b', new Health(1000,1000), 75, 30, 4, 250,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='g'){
                    Unit monster = new Monster ("Giant-Wright", 'g', new Health(1500,1500), 100, 40, 5, 500,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='w'){
                    Unit monster = new Monster ("White Walker", 'w', new Health(2000,2000), 150, 50, 6, 1000,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='M'){
                    Unit monster = new Monster ("The Mountain", 'M', new Health(1000,1000), 60, 25, 6, 500,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='C'){
                    Unit monster = new Monster ("Queen Cersei" ,'C', new Health(100,100), 10, 10, 1, 1000,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='K'){
                    Unit monster = new Monster ("Night’s King", 'K', new Health(5000,5000), 300, 150, 8, 5000,new Position(lineNumber,i));
                    units.add(monster);
                }
                if(c=='B'){
                    Unit trap = new Trap ("Bonus Trap", 'B', new Health(1,1), 1, 1, 250, 5, 6,2,new Position(lineNumber,i));
                    units.add(trap);
                }
                if(c=='Q'){
                    Unit trap = new Trap ("Queen’s Trap", 'Q', new Health(250,250), 50, 10, 100, 4, 10,4,new Position(lineNumber,i));
                    units.add(trap);
                }
                if(c=='D'){
                    Unit trap = new Trap ("Death Trap", 'D', new Health(500,500), 100, 20, 250, 6, 10,3,new Position(lineNumber,i));
                    units.add(trap);
                }
                if(c=='#'){
                    this.pos.setPosition(lineNumber,i);
                    walls.add(this.pos);
                }
                if(c=='.'){
                    this.pos.setPosition(lineNumber,i);
                    free.add(this.pos);
                }
            }
            lineNumber=lineNumber+1;
        }
    }

    public boolean moveUp(Unit unit){
        Position toMove =new Position(unit.getPosition().getX(),unit.getPosition().getY()-1);
        if(free.contains(toMove)){
            free.remove(toMove);
            toMove.setY(toMove.getY()+1);
            free.add(toMove);
            units.remove(unit);
            unit.setPosition(unit.getPosition().getX(),unit.getPosition().getY()-1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean moveDown(Unit unit){
        Position toMove =new Position(unit.getPosition().getX(),unit.getPosition().getY()+1);
        if(free.contains(toMove)){
            free.remove(toMove);
            toMove.setY(toMove.getY()-1);
            free.add(toMove);
            units.remove(unit);
            unit.setPosition(unit.getPosition().getX(),unit.getPosition().getY()+1);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveLeft(Unit unit){
        Position toMove =new Position(unit.getPosition().getX()-1,unit.getPosition().getY());
        if(free.contains(toMove)){
            free.remove(toMove);
            toMove.setX(toMove.getY()+1);
            free.add(toMove);
            units.remove(unit);
            unit.setPosition(unit.getPosition().getX()-1,unit.getPosition().getY());
            return true;
        }
        else{
            return false;
        }
    }

    public boolean moveRight(Unit unit){
        Position toMove =new Position(unit.getPosition().getX()+1,unit.getPosition().getY());
        if(free.contains(toMove)){
            free.remove(toMove);
            toMove.setX(toMove.getY()-1);
            free.add(toMove);
            units.remove(unit);
            unit.setPosition(unit.getPosition().getX()+1,unit.getPosition().getY());
            return true;
        }
        else{
            return false;
        }
    }

    public boolean move(Unit unit, String direction){}
}
