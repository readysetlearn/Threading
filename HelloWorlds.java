public class HelloWorlds implements Runnable{

    private static final int MAX_THREADS = 10;
    private static int threadCounter;

    @Override
    public void run() {
        System.out.println("Hi from a thread! Counter is "+threadCounter);
    }

    public static void main(String[] args) {
        System.out.println("Hello from main.");
        for (threadCounter = 0; threadCounter < MAX_THREADS; threadCounter++) {
            Thread th = (new Thread(new HelloWorlds()));
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                System.out.println("Error: thread was interupted");
            }
        }
    }
}
