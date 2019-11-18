package thread.management.demon;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        Deque<Event> deque=new ConcurrentLinkedDeque<>();

        WriterTask writer=new WriterTask(deque);
        for (int i=0; i< Runtime.getRuntime().availableProcessors(); i++){
            Thread thread=new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner=new CleanerTask(deque);
        cleaner.start();
    }
}
