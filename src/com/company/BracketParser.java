package com.company;

import java.util.HashMap;
import java.util.Map;

public class BracketParser extends AbstractAlgo {
    private String bracketDict = "{[()]}";
    private Map<Character, Integer> bracketCounter;
    private String data;

    public BracketParser() {
        bracketCounter = new HashMap<Character, Integer>();
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
    Boolean isBracketCorrect() throws Exception {
        if (getData().isEmpty()) {
            throw new Exception("Wrong data, please require correct data");
        }
        for (char ch : getData().toCharArray()) {
            if (bracketDict.indexOf(ch) != -1) {
                bracketCounter.put(ch, bracketCounter.getOrDefault(ch, 0) + 1);
            }
        }
        for (int i = 0; i < bracketDict.length() / 2; i++) {
            if (!bracketCounter.getOrDefault(bracketDict.charAt(i), 0).equals(bracketCounter.getOrDefault(bracketDict.charAt(bracketDict.length() - 1 - i), 0))){
                return false;
            }
        }
        return true;
    }
}
