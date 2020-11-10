
Создаем ThreadPoolExecutor
you can send Runnable or Callable objects to be executed.


Executes the given task sometime in the future.

information about the executor

* getPoolSize (): этот метод возвращает фактическое количество потоков в пуле исполнителя.
* getActiveCount (): этот метод возвращает количество потоков, которые были выполнение заданий в исполнителе.
* getTaskCount (): этот метод возвращает количество задач, которые были планируется к исполнению. Возвращаемое значение является только приблизительным, потому что оно меняется динамически.
* getCompletedTaskCount (): этот метод возвращает количество задач завершенных исполнителем.