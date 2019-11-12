##Running a task in an executor after a delay

The Executor framework provides the ThreadPoolExecutor class to execute Callable
and Runnable tasks with a pool of threads, which helps you avoid all thread creation
operations. When you send a task to the executor, it's executed as soon as possible,
according to the configuration of the executor.
 *
 There are use cases when you are not  interested in executing a task as soon as possible. You may want to execute a task after a
period of time or do it periodically. For these purposes, the Executor framework provides
the ScheduledExecutorService interface along with its implementation, namely the
ScheduledThreadPoolExecutor class.
In this recipe, you will learn how to create ScheduledThreadPoolExecutor and use it to
schedule the execution of a task after a given period of time.