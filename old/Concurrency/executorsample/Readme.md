jps - Lists the instrumented Java Virtual Machines (JVMs) on the target system. This command is experimental and unsupported.

****
****
Зная pid процесса, мы можем открыть данные сразу по нему: jvisualvm --openpid [] айдипроцесса
https://javarush.ru/groups/posts/2047-threadom-java-ne-isportishjh--chastjh-i---potoki

## Executor, ThreadPool, Fork Join

* Executor для execute
* ExecutorService — особый Executor, который имеет набор возможностей по управлению ходом выполнения.
* Executors - фабрика , которая позволяет создавать ExecutorService

### ScheduledExecutorService
ExecutorService типа ScheduledExecutorService позволяют запускать задачи по расписанию (schedule).