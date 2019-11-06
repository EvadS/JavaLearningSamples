package thread.management.croupingthreads;

/**
 * stores thread objects and other ThreadGroup objects associated
 * with it so it can access all of their information (status, for example) and perform operations
 * over all its members (interrupt, for example).
 */
public class MyThreadGroup extends ThreadGroup {


    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n", t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
