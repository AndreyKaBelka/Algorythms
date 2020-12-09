package algorythms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitonicSort implements Algorythm {

    private void compAndSwap(ArrayList<Integer> a, int i, int j, int dir) {
        if ((a.get(i) > a.get(j) && dir == 1) ||
                (a.get(i) < a.get(j) && dir == 0)) {
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        }
    }

    private void bitonicMerge(ArrayList<Integer> a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    private void bitonicSort(ArrayList<Integer> a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            bitonicSort(a, low, k, 1);

            bitonicSort(a, low + k, k, 0);

            bitonicMerge(a, low, cnt, dir);
        }
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        bitonicSort(a, 0, a.size(), 1);
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 7, 4, 8, 6, 2, 1, 5));
        BitonicSort ob = new BitonicSort();
        System.out.println(ob.sort(a));
    }
}
