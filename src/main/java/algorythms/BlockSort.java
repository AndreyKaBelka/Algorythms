package algorythms;

import java.util.ArrayList;

public class BlockSort implements Algorythm {
    public BlockSort() {
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        ArrayList<Integer> bucket = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {//n
            bucket.add(0);//1
        }
        //n

        for (Integer datum : data) {//n
            bucket.set(datum, bucket.get(datum) + 1);//2
        }
        //2n+n

        int k = 0;//1
        for (int i = 0; i < bucket.size(); i++) {//n
            for (int j = 0; j < bucket.get(i); j++) {//n
                data.set(k++, i);//2
            }
        }
//        2n+n+1+2n**2=2n**2+3n+1
        return data;
    }
}
