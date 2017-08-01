public class HelloWorlds implements Runnable{

    private static final int MAX_THREADS = 10;
    private final int counter;//used to distinguish between threads

    /*class constructor*/
    public HelloWorlds(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Hello worlds! This is thread "+counter);
    }

    public static void main(String[] args) {
        System.out.println("Hello from main.");
        Thread[] threads = new Thread[MAX_THREADS];

        //create threads
        for (int i = 0; i < MAX_THREADS; i++) {
            threads[i] = (new Thread(new HelloWorlds(i)));
        }

        //start threads
        for(int i = 0; i < MAX_THREADS; i++) {
            threads[i].start();
        }
    }
}
