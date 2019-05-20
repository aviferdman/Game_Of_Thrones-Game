package Random;

import java.util.Random;

public class NDRandom implements RandomGenerator {
    private Random rand;

    public NDRandom(){
        rand = new Random(123);
    }

    @Override
    public int nextInt ( int n ) {
        return rand.nextInt(n);
    }
}
