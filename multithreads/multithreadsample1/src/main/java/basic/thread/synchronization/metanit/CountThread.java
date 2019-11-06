package basic.thread.synchronization.metanit;

/**
 * Каждый объект в Java имеет ассоциированный с ним монитор.
 */
class CountThread implements Runnable{

    CommonResource commonResource;

    CountThread(CommonResource commonResource){
        this.commonResource = commonResource;
    }

    public void run(){
        synchronized(commonResource) {

            commonResource.x = 1;
            for (int i = 1; i < 5; i++) {

                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
