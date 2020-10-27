package algorythms;

import java.util.ArrayList;

public class ShakerSort implements Algorythm {

    ShakerSort(){}

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        boolean isEnded = false;
        boolean isNotBreakable = true;
        int i = 0;
        int max = data.size()-1;
        int min = 0;
        int temp;
        while (isNotBreakable) {
            if (!isEnded) {
                if (data.get(i) > data.get(i + 1)) {
                    temp = data.get(i);
                    data.set(i, data.get(i + 1));
                    data.set(i + 1, temp);
                }
                i++;
            }
            if (isEnded) {
                if (data.get(i) < data.get(i - 1)) {
                    temp = data.get(i);
                    data.set(i, data.get(i - 1));
                    data.set(i - 1, temp);
                }
                i--;
            }
            if (i == max) {
                isEnded = true;
                max--;
                i--;
            }
            if (i == min) {
                isEnded = false;
                min++;
                i++;
            }
            if (min - max == 1 || min == max) {
                isNotBreakable = false;
            }
        }
        return data;
    }
}
