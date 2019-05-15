import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Board {
    int width;
    int length;
    Unit [] units;
    public Board (){
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

                }
                lineNumber=lineNumber+1;
            }
        }
    }
    public void Tick (){
        for (Unit unit : units) {
            unit.play();
        }
    }
}
