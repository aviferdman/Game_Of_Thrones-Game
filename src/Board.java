import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public class Board {

    private int width;
    private int length;
    private Player player;
    private Health health = new Health(0,0);
    private Position pos = new Position();
    LinkedList<Unit> units = new LinkedList<>();
    private LinkedList<Position> free = new LinkedList<>();
    private LinkedList<Position> walls = new LinkedList<>();

    public Board (Player player){
        this.player=player;
        setBoard("C:\\HW3\\level1.txt");
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
                    this.health.setCurrentHealth(80);
                    Unit monster = new Monster ("Lannister Solider" ,'s',this.health, 8, 3, 3, 25,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='k'){
                    this.health.setCurrentHealth(200);
                    Unit monster = new Monster ("Lannister Knight", 'k', this.health, 14, 8, 4, 50,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='q'){
                    this.health.setCurrentHealth(400);
                    Unit monster = new Monster ("Queen’s Guard", 'q', this.health, 20, 15, 5, 100,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='z'){
                    this.health.setCurrentHealth(600);
                    Unit monster = new Monster ("Wright", 'z', this.health, 30, 15, 3, 100,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='b'){
                    this.health.setCurrentHealth(1000);
                    Unit monster = new Monster ("Bear-Wright", 'b', this.health, 75, 30, 4, 250,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='g'){
                    this.health.setCurrentHealth(1500);
                    Unit monster = new Monster ("Giant-Wright", 'g', this.health, 100, 40, 5, 500,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='w'){
                    this.health.setCurrentHealth(2000);
                    Unit monster = new Monster ("White Walker", 'w', this.health, 150, 50, 6, 1000,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='M'){
                    this.health.setCurrentHealth(1000);
                    Unit monster = new Monster ("The Mountain", 'M', this.health, 60, 25, 6, 500,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='C'){
                    this.health.setCurrentHealth(100);
                    Unit monster = new Monster ("Queen Cersei" ,'C', this.health, 10, 10, 1, 1000,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='K'){
                    this.health.setCurrentHealth(5000);
                    Unit monster = new Monster ("Night’s King", 'K', this.health, 300, 150, 8, 5000,this.pos);
                    monster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='B'){
                    this.health.setCurrentHealth(1);
                    Unit trap = new Trap ("Bonus Trap", 'B', this.health, 1, 1, 1, 250, 5, 6,2,this.pos);
                    trap.setPosition(lineNumber,i);
                    units.add(trap);
                }
                if(c=='Q'){
                    this.health.setCurrentHealth(250);
                    Unit trap = new Trap ("Queen’s Trap", 'Q', this.health, 50, 10, 1, 100, 4, 10,4,this.pos);
                    trap.setPosition(lineNumber,i);
                    units.add(trap);
                }
                if(c=='D'){
                    this.health.setCurrentHealth(500);
                    Unit trap = new Trap ("Death Trap", 'D', this.health, 100, 20, 1, 250, 6, 10,3,this.pos);
                    trap.setPosition(lineNumber,i);
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
        Position toMove =new Position();
        toMove.setX(unit.getPosition().getX());
        toMove.setY(unit.getPosition().getY()-1);
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
        Position toMove =new Position();
        toMove.setX(unit.getPosition().getX());
        toMove.setY(unit.getPosition().getY()+1);
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
        Position toMove =new Position();
        toMove.setX(unit.getPosition().getX()-1);
        toMove.setY(unit.getPosition().getY());
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
        Position toMove =new Position();
        toMove.setX(unit.getPosition().getX()+1);
        toMove.setY(unit.getPosition().getY());
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
}
