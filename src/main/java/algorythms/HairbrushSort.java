package algorythms;

import java.util.ArrayList;

public class HairbrushSort implements Algorythm {
    public HairbrushSort() {
    }

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        Integer temp;
        double step = data.size() - 2;
        while (step >= 1) { //(n-1)
            for (int i = 0; i < data.size() - 1; i++) { //n-1
                for (int j = ((int) (i + step)); j < data.size(); j++) { //n
                    if (data.get(i) > data.get(j)) { //1
                        temp = data.get(i); //1
                        data.set(i, data.get(j)); //2
                        data.set(j, temp); //1
                    }
                }
            }
            step -= 1.2473; //2
        }
        //(((n-1)*2)(n-1))(n)5 = (2n**2-4n+2)*5n=10n**3-20n**2+10n
        return data;
    }
}
