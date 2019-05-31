package Random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DRandom implements RandomGenerator{

    private Iterator<Integer> generatedNumbers;
    private Iterator<Character> generatedUserInput;

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
    }

    public int nextInt ( int n ) {
        return generatedNumbers.next();
    }

    @Override
    public char nextChar() {
        return generatedUserInput.next();
    }
}
