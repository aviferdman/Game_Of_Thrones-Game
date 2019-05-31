package Random;

import java.util.Random;
import java.util.Scanner;

public class NDRandom implements RandomGenerator {

    private final Random rand;
    private final Scanner sc;

    public NDRandom() {
        rand = new Random(123);
        sc = new Scanner(System.in);
    }

    @Override
    public int nextInt(int n) {
        return rand.nextInt(n);
    }

    @Override
    public char nextChar() {
        return sc.next().charAt(0);
    }
}
