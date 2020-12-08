package operationsAlg;

import java.util.HashMap;
import java.util.LinkedList;

public class BracketParser extends AbstractAlgo {
    private final HashMap<Character, Character> dict = new HashMap<>() {
        {
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }
    };
    private LinkedList<Character> stack;
    private String data;

    public BracketParser() {
        stack = new LinkedList<>();
        data = null;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        if (data == null || data.isEmpty()) {
            return "";
        }
        return data;
    }

    @Override
    public Boolean isBracketCorrect() throws Exception {
        if (getData().isEmpty()) {
            throw new Exception("Wrong data, please require correct data");
        }
        for (char ch : getData().toCharArray()) {
            if (dict.containsValue(ch)) {
                stack.push(ch);
            } else if (dict.containsKey(ch)) {
                if (stack.size() == 0 || dict.get(ch) != stack.pop()){
                    return false;
                }
            } else {
                throw new Exception("Wrong data, please require correct data");
            }
        }
        return true;
    }
}
