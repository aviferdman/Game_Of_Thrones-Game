import java.util.Random;
public class NDRandom extends IRandom {
    @Override
    public int nextInt ( int n ) {
        Random rand = new Random();
        int output = rand.nextInt(n+1);
        return output;
    }
}
