package algorythms;

import java.util.ArrayList;

public class ChooseSort implements Algorythm {
    public ChooseSort() {}

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        for (int min = 0; min < data.size(); min++) { //n
            int least = min; //1
            for (int j = min + 1; j < data.size(); j++) { //(n-1)
                if (data.get(j) < data.get(least)) { //1
                    least = j; //1
                }
            }
            int tmp = data.get(min); //1
            data.set(min, data.get(least)); //2
            data.set(least, tmp); //1
        }
        //n*(1+(n-1)*2+4) = 2n(n-1) + 5n = 2n**2-2n+5n=2n**2+3n
        return data;
    }
}
