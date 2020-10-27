package algorythms;

import java.util.ArrayList;

public class BubbleSort implements Algorythm {
    public BubbleSort() {
    }

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        Integer temp;
        //n
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) { //5*(n-1)
                //1 операция
                if (data.get(i) > data.get(j)) {
                    //1 операция
                    temp = data.get(i);
                    //2 операции
                    data.set(i, data.get(j));
                    //1 операции
                    data.set(j, temp);
                }
            }
        }
        //n*5*(n-1) = 5n**2-5n
        return data;
    }
}
