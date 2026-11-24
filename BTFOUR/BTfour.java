package BTFOUR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTfour {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(100); // -> số ô là 100 ô để chứa các phần tử
        List<String> list2 = new LinkedList<>();
        for(int i = 1; i <11; i++){
            list1.add(String.valueOf(i));
        }
        for(int i = 1; i<11; i++){
            list2.add(String.valueOf(i));
        }
        System.out.println(list1.size() +  " + " + list2.size());
        for(int i = 1; i<10; i++){
            list1.get(i);
            list2.get(i);
        }
        System.out.println(list1.size() +  " + " + list2.size());
        long start = System.nanoTime();
        list1.remove("1");
        list1.remove("2");
        list1.remove("3");
        list1.remove("4");
        long end = System.nanoTime();

        long start1 = System.nanoTime();
        list2.remove("1");
        list2.remove("2");
        list2.remove("3");
        list2.remove("4");
        long end1 = System.nanoTime();

        System.out.printf("Của ArrayList: %d\n", end-start);
        System.out.printf("Của LinkedList : %d\n", end1 - start1);
    }
}
