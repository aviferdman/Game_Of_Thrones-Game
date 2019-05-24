package Random;

import java.util.Random;

public class NDRandom implements RandomGenerator {
    private Random rand;

    public NDRandom() {
        rand = new Random(123);
    }

    @Override
    public int nextInt(int n) {
        return rand.nextInt(n);
    }

    @Override
    public char nextChar() {
        int random = rand.nextInt(6);
        if (random == 1) {
            return 'w';
        } else if (random == 2) {
            return 's';
        } else if (random == 3) {
            return 'a';
        } else if (random == 4) {
            return 'd';
        } else if (random == 5) {
            return 'e';
        } else {
            return 'q';
        }
    }
}
