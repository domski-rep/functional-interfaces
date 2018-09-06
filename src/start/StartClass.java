package start;

import static myown.creators.MyListCreator.collectFrom;

import myown.interfaces.MyMapper;
import myown.interfaces.MySelector;

import java.util.Arrays;
import java.util.List;


public class StartClass {

    public StartClass() {
        init();
    }

    private void init() {
        List<Integer> src1 = Arrays.asList(1, 2, 3, 7, 19, 111, 12);
        System.out.println(testList_1(src1)); // <--- test_1 is about select
        // numbers < 10 , add 10 to each and return
        // list of those numbers

        List<String> src2 = Arrays.asList("aa", "bbbb", "ccccccc", "ddddddddddaaaeee ");
        System.out.println(testList_2(src2)); // <--- test_2 is about select Strings with
        // String length > 3 , add 10 to each
        // selected length and return list of those numbers
    }

    public List<Integer> testList_1(List<Integer> source) {
        MySelector<Integer> selector = new MySelector<Integer>() {
            @Override
            public boolean select(Integer value) {
                if (value < 10)
                    return true;
                else
                    return false;

            }
        };

        MyMapper<Integer, Integer> mapper = new MyMapper<Integer, Integer>() {

            @Override
            public Integer map(Integer value) {
                return value + 10;
            }
        };

        return collectFrom(source).when(selector).mapEvery(mapper);
    }

    public List<String> testList_2(List<String> source) {
        MySelector<String> selector = new MySelector<String>() {
            @Override
            public boolean select(String value) {
                if (value.length() > 3)
                    return true;
                else
                    return false;

            }
        };

        MyMapper<String, Integer> mapper = new MyMapper<String, Integer>() {
            @Override
            public Integer map(String value) {
                return value.length() + 10;
            }
        };

        return collectFrom(source).when(selector).mapEvery(mapper);
    }


    public static void main(String[] args) {
        new StartClass();
    }

}

