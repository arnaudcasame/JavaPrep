package Helpers;

import java.util.List;

public class ArrayHelper<T> {

    public T[] fromListToArray(List<T> list){
        T[] res = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public T[][] fromEmbeddedListToArray(List<List<T>> list){
        T[][] res = (T[][]) new Object[list.size()];
        for(int j=0; j<list.size(); j++){
            T[] inner = (T[]) new Object[list.get(j).size()];
            for (int i=0; i < list.get(j).size(); i++) {
                inner[i] = list.get(j).get(i);
            }
            res[j] = inner;
        }
        return res;
    }
}
