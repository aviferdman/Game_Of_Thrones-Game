import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Board {
    int width;
    int length;
    Player player;
    Unit [] units;
    public Board (Player player){
        this.player=player;
        File file =
                new File("C:\\HW3\\level1.txt");
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
                    Monster monster = new Monster ("Lannister Solider" ,'s',80, 8, 3, 3, 25);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='k'){
                    Monster monster = new Monster ("Lannister Knight", 'k', 200, 14, 8, 4, 50);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='q'){
                    Monster monster = new Monster ("Queen’s Guard", 'q', 400, 20, 15, 5, 100);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='z'){
                    Monster monster = new Monster ("Wright", 'z', 600, 30, 15, 3, 100);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='b'){
                    Monster monster = new Monster ("Bear-Wright", 'b', 1000, 75, 30, 4, 250);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='g'){
                    Monster monster = new Monster ("Giant-Wright", 'g', 1500, 100, 40, 5, 500);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='w'){
                    Monster monster = new Monster ("White Walker", 'w', 2000, 150, 50, 6, 1000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='M'){
                    Monster monster = new Monster ("The Mountain", 'M', 1000, 60, 25, 6, 500);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='C'){
                    Monster monster = new Monster ("Queen Cersei" ,'C', 100, 10, 10, 1, 1000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
                if(c=='K'){
                    Monster monster = new Monster ("Night’s King", 'K', 5000, 300, 150, 8, 5000);
                    moster.setPosition(lineNumber,i);
                    units.add(monster);
                }
            }
            lineNumber=lineNumber+1;
        }
    }
    public void Tick (){
        for (Unit unit : units) {
            unit.play();
        }
    }
}
