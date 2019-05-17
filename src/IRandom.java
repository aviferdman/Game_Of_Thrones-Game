public class IRandom implements RandomGenerator {

    private static IRandom instance = null;

    private IRandom() { }

    public static IRandom getInstance(String pathToD){

        if (instance == null) {
            if(pathToD==null){
                instance = new NDRandom();
            }
            else{
                instance = new DRandom(string WhereTheFuckThisTextFile);
            }
        }
        return instance;
    }


    public int nextInt ( int n ) {
        return instance.nextInt(n);
    }
}
