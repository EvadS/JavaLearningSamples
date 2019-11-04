package treads;

class JThread extends Thread {

    JThread(String name){
        super(name);
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiNished... \n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Main thread started...");

        new JThread("JThread").start();
        System.out.println("Main thread finished...");

        //------------------------------------------
        System.out.println("Main thread started...");
        for(int i=1; i < 6; i++)
            new JThread("JThread " + i).start();
        System.out.println("Main thread finished...");

//В этом случае текущий поток будет ожидать завершения потока, для которого вызван метод join:

        System.out.println("Main thread started...");
        JThread t= new JThread("JThread ");
        t.start();
        try{
            t.join();
        }
        catch(InterruptedException e){

            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");

    }

}