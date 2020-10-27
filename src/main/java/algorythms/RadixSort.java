package algorythms;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort implements Algorythm {
    public RadixSort() {
    }

    @Override
    public ArrayList<Integer> sort(final ArrayList<Integer> data) {
        int maxRadixCount = String.valueOf(Collections.max(data)).length();//2
        int rang = 10;//1
        ArrayList<Integer> res = new ArrayList<>();//1
        for (int i = 0; i < maxRadixCount; i++) {//n
            ArrayList<ArrayList<Integer>> b = new ArrayList<>();//1
            for (int j = 0; j < rang; j++) {//10
                b.add(new ArrayList<>());//1
            }
            //10
            for (int x : data) {//n
                int figure = (int) (x % (Math.pow(10, i) % 10));//4
                b.get(figure).add(x);//1
            }
            for (int k = 0; k < rang; k++) {//10
                res.addAll(b.get(k));//1
            }
        }
        //4+n*(1+10+5n+10)=5n**2+21n+4
        return res;
    }
}
