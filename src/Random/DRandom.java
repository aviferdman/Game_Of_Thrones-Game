package Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DRandom implements RandomGenerator{

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
            nextInt = sc.nextLine();
        }
    }

    public int nextInt ( int n ) {
        int output=-1;
        if (nextInt!=null){
            output = Integer.parseInt(nextInt);
            if(sc.hasNextLine()){
                nextInt = sc.nextLine();
            }
        }
        return output;
    }

}
