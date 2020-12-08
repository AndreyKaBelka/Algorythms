package operationsAlg;

import java.util.Arrays;
import java.util.LinkedList;

public class SmallestRAL {
    private LinkedList<Integer> stack = new LinkedList<>();
    private int[] data;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SmallestRAL() {
        this.data = null;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Put legal arg");
        }
        this.data = data;
    }

    public int[] calc() {
        int[] ans = new int[2];
        int tempAns = 0;
        for (int i = getData().length - 1; i >= 0; i--) {
            if (getData()[i] == getNumber()) {
                ans[1] = tempAns;
                stack.clear();
                continue;
            }
            while (stack.size() > 0 && getData()[stack.getFirst()] >= getData()[i]) {
                stack.removeFirst();
            }

            if (stack.size() == 0) {
                tempAns = getData()[i];
            }
            stack.push(i);
        }
        ans[0] = tempAns;
        return ans;
    }

    public static void main(String[] args) {
        SmallestRAL smallestRAL = new SmallestRAL();
        smallestRAL.setData(new int[]{6, 5, 9, 8, 7, 1, 2, 3, 5});
        smallestRAL.setNumber(2);
        System.out.println(Arrays.toString(smallestRAL.calc()));
    }
}
