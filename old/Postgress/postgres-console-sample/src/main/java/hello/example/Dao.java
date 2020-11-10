package hello.example;

import java.util.List;

public interface Dao<T> {

    void save(T t);

    T load(long id);

    void delete(long id);

    void update(T t);

    List<T> loadAll();
}