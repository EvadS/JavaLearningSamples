package basic.thread.synchronization.incremenator;

/**
 * может пройти до секунды времени между тем, когда будет выполнен метод finish(), и фактическим завершения потока.
 */
class Incremenator extends Thread
{
    // без volatile, может кэшироваться отдельно для каждого потока
    private volatile boolean mIsIncrement = true;
    private volatile boolean mFinish = false;

    public void changeAction()	//Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }
    public void finish()		//Инициирует завершение потока
    {
        mFinish = true;
    }

    @Override
    public void run()
    {
        do
        {
            if(!mFinish)	//Проверка на необходимость завершения
            {
                if(mIsIncrement)
                    Program.mValue++;	//Инкремент
                else
                    Program.mValue--;	//Декремент

                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
            }
            else
                return;		//Завершение потока

            try{
                Thread.sleep(1000);		//Приостановка потока на 1 сек.
            }catch(InterruptedException e){}
        }
        while(true);
    }
}
