
The invokeAny() method of the ThreadPoolExecutor class receives a list of tasks, then launches them, and returns the
result of the first task that finishes without throwing an exception.

This method returns the same data type that the call() method of the tasks returns. In this case, it returned a
String value.

Main, have two tasks that can return the true value or throw Exception

* Both tasks return the true value. Here, the result of the invokeAny() method is
the name of the task that finishes in the first place.

* The first task returns the true value and the second one throws Exception .
Here, the result of the invokeAny() method is the name of the first task.

* The first task throws Exception and the second one returns the true value.
Here, the result of the invokeAny() method is the name of the second task.

* Both tasks throw Exception . In such a class, the invokeAny() method throws
an ExecutionException exception.