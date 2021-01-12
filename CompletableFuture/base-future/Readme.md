# CompletableFuture

новый класс для асинхронной работы, который дает возможность комбинировать шаги обработки,
## base diff
**supplyAsync()** принимает Supplier, а **runAsync** -> Runnable. Проще говоря, с помощью **_supplyAsync_**() 
можно вернуть **результат**, с runAsync() - нельзя.