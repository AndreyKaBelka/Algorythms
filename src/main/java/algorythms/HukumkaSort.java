package algorythms;

import java.util.ArrayList;

public class HukumkaSort implements Algorythm {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        int i = 1;
        int j = 2;
        int temp;
        while (i < data.size()) {//n-1
            if (data.get(i - 1) < data.get(i)) {//1
                i = j;//1
                j = j + 1;//2
            } else {//10
                temp = data.get(i);//1
                data.set(i, data.get(i - 1));//2
                data.set(i - 1, temp);//1
                i = i - 1;//2
                if (i == 0) {//1
                    i = j;//1
                    j++;//2
                }
            }
        }
        //(n-1)*11 + 2 = 11n - 11 + 2 = 11n - 9
        return data;
    }
}
