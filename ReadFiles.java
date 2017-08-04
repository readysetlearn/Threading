import java.io.File;
import java.io.FileNotFoundException;
import java.util. Scanner;


public class ReadFiles implements Runnable {

    /*Constructor*/
    public ReadFiles(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
            while(in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.close();

    }

    public static void main(String[] args) {
        final String start = "Test.txt";
        Scanner in = null;
        try {
            in = new Scanner(new File(start));
            while(in.hasNextLine()) {
                Thread t = new Thread(new ReadFiles(in.nextLine()));
                t.start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.close();

    }

    /*instance variables*/
    private final String fileName;
}
