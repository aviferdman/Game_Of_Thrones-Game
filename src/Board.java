import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public class Board {

    int width;
    int length;
    Player player;
    List<Unit> units = new LinkedList<>();
    List<Position> free = new LinkedList<>();
    List<Position> walls = new LinkedList<>();

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
    public List<Unit> getUnits(){
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

    public void setUnits(List<Unit> units) {
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
                    Unit monster = new Monster ("Lannister Solider" ,'s',80, 8, 3, 3, 25);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='k'){
                    Unit monster = new Monster ("Lannister Knight", 'k', 200, 14, 8, 4, 50);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='q'){
                    Unit monster = new Monster ("Queen’s Guard", 'q', 400, 20, 15, 5, 100);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='z'){
                    Unit monster = new Monster ("Wright", 'z', 600, 30, 15, 3, 100);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='b'){
                    Unit monster = new Monster ("Bear-Wright", 'b', 1000, 75, 30, 4, 250);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='g'){
                    Unit monster = new Monster ("Giant-Wright", 'g', 1500, 100, 40, 5, 500);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='w'){
                    Unit monster = new Monster ("White Walker", 'w', 2000, 150, 50, 6, 1000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='M'){
                    Unit monster = new Monster ("The Mountain", 'M', 1000, 60, 25, 6, 500);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='C'){
                    Unit monster = new Monster ("Queen Cersei" ,'C', 100, 10, 10, 1, 1000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='K'){
                    Unit monster = new Monster ("Night’s King", 'K', 5000, 300, 150, 8, 5000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='B'){
                    Unit trap = new Trap ("Bonus Trap", 'B', 1, 1, 1, 250, 5, 6, 2);
                    trap.setPosition(lineNumber,i);
                    units.add(trap);
                }
                if(c=='Q'){
                    Unit trap = new Trap ("Queen’s Trap", 'Q', 250, 50, 10, 100, 4, 10, 4);
                    trap.setPosition(lineNumber,i);
                    units.add(trap);
                }
                if(c=='D'){
                    Unit trap = new Trap ("Death Trap", 'D', 500, 100, 20, 250, 6, 10, 3);
                    trap.setPosition(lineNumber,i);
                    units.add(trap);
                }
                if(c=='#'){
                    walls.add(lineNumber,i);
                }
                if(c=='.'){
                    free.add(lineNumber,i);
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
