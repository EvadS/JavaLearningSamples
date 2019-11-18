package basic.thread.synchronization.metanit;

public class Program {
    public static void main(String[] args) {

        CommonResource commonResource= new CommonResource();
        //запускается пять потоков.
        // мы ожидаем, что каждый поток будет увеличивать res.x с 1 до 4 и так пять раз

        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread "+ i);
            t.start();
        }
    }
}
