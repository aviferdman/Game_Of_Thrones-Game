import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DRandom extends IRandom{

    String nextInt;
    Scanner sc;

    public DRandom (String path){
        File file = new File(path);
        sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc.hasNextLine()) {
            String nextInt = sc.nextLine();
        }
    }

    public int nextInt ( int n ) {
        int output=-1;
        if (nextInt!=null&sc!=null){
            output = Integer.parseInt(nextInt);
            String nextInt = sc.nextLine();
        }
        return output;
    }

}
