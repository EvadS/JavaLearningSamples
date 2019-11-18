

пример того как рабюотать с TaskExecutor  -> callable 

The Java Concurrency API 
* Callable: этот интерфейс имеет метод call (). В этом методе вы должны
реализовать логику задачи. Интерфейс Callable является параметризованным
интерфейс, то есть вы должны указать тип данных, которые вызовет метод call ()
вернуть.
 * Future: у этого интерфейса есть несколько методов для получения результата, генерируемого
Вызываемый объект и управление его состоянием

One of the advantages of the Executor framework is that it allows you to run concurrent
tasks that return a result.
