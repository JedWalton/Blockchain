class SimpleCounter {
    // write your code here
    public int counter;

    private static final SimpleCounter INSTANCE = new SimpleCounter();

    private SimpleCounter() {

    }

    public static SimpleCounter getInstance() {
        return INSTANCE;
    }

}