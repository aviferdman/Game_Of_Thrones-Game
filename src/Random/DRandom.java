package Random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DRandom implements RandomGenerator{
    Iterator<Integer> generatedNumbers;
    Iterator<Character> generatedUserInput;

    public DRandom(List<Integer> generatedNumbers, List<Character> generatedUserInput){
        this.generatedNumbers = generatedNumbers.iterator();
        this.generatedUserInput = generatedUserInput.iterator();
    }

    public DRandom (String randomNumbersPath, String userInputPath){
        try {
            generatedNumbers = Files.readAllLines(Paths.get(randomNumbersPath)).stream().map(Integer::parseInt).collect(Collectors.toList()).iterator();
            generatedUserInput = Files.readAllLines(Paths.get(userInputPath)).stream().map(s -> s.charAt(0)).collect(Collectors.toList()).iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*File file = new File(randomNumbersPath);
        sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc.hasNextLine()) {
            nextInt = sc.nextLine();
        }*/
    }

    public int nextInt ( int n ) {
        /*int output=-1;
        if (nextInt!=null){
            output = Integer.parseInt(nextInt);
            if(sc.hasNextLine()){
                nextInt = sc.nextLine();
            }
        }
        return output;*/
        return generatedNumbers.next();
    }

    @Override
    public char nextChar() {
        /*char output = 'q';
        if (nextInt!=null){
            output = nextInt.charAt(0);
            if(sc.hasNextLine()){
                nextInt = sc.nextLine();
            }
        }
        return output;*/
        return generatedUserInput.next();
    }
}
