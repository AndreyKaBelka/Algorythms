import algorythms.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
        Algorythm radixSort = new BlockSort();
        System.out.println(radixSort.sort(data));
    }
}
