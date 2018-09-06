package myown.creators;

import myown.interfaces.MyMapper;
import myown.interfaces.MySelector;

import java.util.ArrayList;
import java.util.List;

public class MyListCreator<S, T> {

    private List<S> sourceList;
    private ArrayList<S> selectedList;
    private ArrayList<T> mappedList;

    public MyListCreator(List<S> source) {
        sourceList = source;
    }

    public static <S> MyListCreator collectFrom(List<S> source) {

        return new MyListCreator(source);
    }

    public MyListCreator when(MySelector<S> selector) {
        selectedList = new ArrayList<>();
        for (S value : sourceList) {
            if (selector.select(value)) {
                selectedList.add(value);
            }
        }
        return this;
    }
    public List<T>mapEvery(MyMapper map){
        mappedList = new ArrayList<>();
        for(S value : selectedList){
            mappedList.add((T)map.map(value));
        }

        return mappedList;
    }
}
