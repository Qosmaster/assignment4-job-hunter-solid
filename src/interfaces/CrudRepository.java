package interfaces;

import java.util.ArrayList;

public interface CrudRepository<T> {
    void add(T entity);
    ArrayList<T> getAll();
    T getById(int id);
    void delete(int id);
}