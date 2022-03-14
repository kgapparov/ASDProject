package Internal.framework.dataAccess;


import java.util.Collection;

public interface CommonDAO<T> {
    void save(String key, T element);
    Collection<T> getAll();
    T loadData(String id);
    void update(String key, T element);
}
