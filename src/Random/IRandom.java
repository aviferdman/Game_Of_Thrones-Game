package Random;

import States.Main;

public class IRandom implements RandomGenerator {

    private static final String RANDOM_NUMBERS_PATH = "random_numbers.txt";
    private static final String USER_INPUT_PATH = "user_actions.txt";
    private static RandomGenerator instance = null;

    private IRandom() { }

    public static RandomGenerator getInstance(){

        if (instance == null) {
            if(Main.determinitic){
                instance = new DRandom(RANDOM_NUMBERS_PATH, USER_INPUT_PATH);
            }
            else{
                instance = new NDRandom();
            }
        }
        return instance;
    }

    public static void setInstance(RandomGenerator newInstance){
        instance = newInstance;
    }

    public int nextInt ( int n ) {
        return instance.nextInt(n);
    }

    public char nextChar () {
        return instance.nextChar();
    }
}
