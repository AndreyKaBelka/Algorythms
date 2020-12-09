package algorythms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitonicSort implements Algorythm {

    private void compAndSwap(ArrayList<Integer> a, int i, int j, int dir) {
        if ((a.get(i) > a.get(j) && dir == 1) ||
                (a.get(i) < a.get(j) && dir == 0)) {//1
            int temp = a.get(i);//1
            a.set(i, a.get(j));
            a.set(j, temp);
        }
    }

    private void bitonicMerge(ArrayList<Integer> a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;//1
            for (int i = low; i < low + k; i++)//n
                compAndSwap(a, i, i + k, dir);//log(n)
            //log(n)*n
            bitonicMerge(a, low, k, dir);//log(n)+1+log(n)*n
            bitonicMerge(a, low + k, k, dir);//log(n)+1+log(n)*n
        }
    }

    private void bitonicSort(ArrayList<Integer> a, int low, int cnt, int dir) {
        if (cnt > 1) {//1
            int k = cnt / 2;//1

            bitonicSort(a, low, k, 1);//log(n)

            bitonicSort(a, low + k, k, 0);//log(n)

            bitonicMerge(a, low, cnt, dir);//1+n+log(n)*n+log(n)+1+log(n)*n+log(n)+1+log(n)*n
        }
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> a) {
        bitonicSort(a, 0, a.size(), 1);//1+1+log(n)+log(n)+1+n+log(n)*n+log(n)+1+log(n)*n+log(n)+1+log(n)*n=5+5*log(n)+3*log(n)*n+n=log(n)*(5+3n)+5+n
        return a;
    }
}
