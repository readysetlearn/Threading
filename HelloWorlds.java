public class HelloWorlds implements Runnable{

    private static final int MAX_THREADS = 10;
    private static int threadCounter;

    @Override
    public void run() {
        System.out.println("Hi from a thread! Counter is "+threadCounter);
    }

    public static void main(String[] args) {
        System.out.println("Hello from main.");
        for(threadCounter = 0; threadCounter < MAX_THREADS; threadCounter++) {
            (new Thread(new HelloWorlds())).start();
        }
    }
}
