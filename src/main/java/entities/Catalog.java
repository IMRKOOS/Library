package entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Catalog <T> implements Predicate<T> {
    private List<T> catalog = new ArrayList<>();

    public List<T> getCatalog() {
        return catalog;
    }
    public void add(T obj){
        catalog.add(obj);
    }

    @Override
    public boolean test(T o) {
        for (T element :
                catalog) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }
    public void hasA(T o) throws IOException {
        if (!(test(o))){
            throw new IOException("Library Exception");
        }
    }

}
