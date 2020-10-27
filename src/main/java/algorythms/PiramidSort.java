package algorythms;

import java.util.ArrayList;

public class PiramidSort implements Algorythm {
    private Integer heapSize;

    public PiramidSort() {
    }

    private void buildHeap(ArrayList<Integer> arrayList) {
        heapSize = arrayList.size(); //1
        for (int i = arrayList.size() / 2; i >= 0; i--) { //n/2
            heapify(arrayList, i); //(n/2+1)*11
        }
        //(n/2)*(n/2+1)*11+1
    }

    private void heapify(ArrayList<Integer> arrayList, int i) {
        int l = left(i); //1
        int r = right(i); //1
        int largest = i; //1
        if (l < heapSize && arrayList.get(i) < arrayList.get(l)) { //2
            largest = l; //1
        }
        if (r < heapSize && arrayList.get(largest) < arrayList.get(r)) { //2
            largest = r; //1
        }
        if (i != largest) { //1
            swap(arrayList, i, largest); //1
            heapify(arrayList, largest);
        }
        //11
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        buildHeap(data);        //(n/2)*(n/2+1)*11+1
        while (heapSize > 1) { //n
            swap(data, 0, heapSize - 1);//1
            heapSize--;//2
            heapify(data, 0);//(n/2+1)*11
        }
        //n*(n/2+1)*11*2*1+(n/2)*(n/2+1)*11+1=(n/2+1)(n*22+(n/2)*11+1)
        return data;
    }

    private void swap(ArrayList<Integer> data, int n, int m) {
        int temp = data.get(n);
        data.set(n, data.get(m));
        data.set(m, temp);
    }
}
