package Internal.framework.dataAccess;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommonDAOMemoryImplement<T> implements CommonDAO<T>{
    private Map<String, T> elements;

    CommonDAOMemoryImplement(){
        elements = new HashMap<>();
    }
    @Override
    public void save(String key, T element) {
        elements.put(key, element);
    }

    @Override
    public Collection<T> getAll() {
        return elements.values();
    }

    @Override
    public T loadData(String id) {
        return elements.get(id);
    }

    @Override
    public void update(String key, T element) {
        elements.put(key, element);
    }
}
