package com.myproject;

import java.util.*;

public class EvaluateWin2 {

    public static Set<Integer> selections = new HashSet<>();
    ComputerBrain brain;
    int selection = 1;

    public void evaluateWin() {
        boolean result = false;
        if(selections.size() > 2) {
            Map<Integer, Integer> subMap = winPossibilities.get(selection);
            for(Map.Entry<Integer, Integer> token : subMap.entrySet()) {
                if(selections.contains(token.getKey())) {
                    if(selections.contains(token.getValue())) {
                        System.out.println("win");
                        result = true;
                    }
                }
            }
        }
    }
//The key for Map is first element of a winning combo
    public static Map<Integer, Map<Integer, Integer>> winPossibilities = new HashMap<>() {{
        put(1, new HashMap<>() {{
            put(2, 3);
            put(4, 7);
            put(5, 9);
        }});
        put(2, new HashMap<>() {{
            put(1, 3);
            put(5, 8);
        }});
        put(3, new HashMap<>() {{
            put(2, 1);
            put(6, 9);
            put(5, 7);
        }});
        put(4, new HashMap<>() {{
            put(1, 7);
            put(5, 6);
        }});
        put(5, new HashMap<>() {{
            put(2, 8);
            put(4, 6);
            put(1, 9);
            put(3, 7);
        }});
        put(6, new HashMap<>() {{
            put(3, 9);
            put(5, 4);
        }});
        put(7, new HashMap<>() {{
            put(4, 1);
            put(8, 9);
            put(5, 3);
        }});
        put(8, new HashMap<>() {{
            put(7, 9);
            put(5, 2);
        }});
        put(9, new HashMap<>() {{
            put(6, 3);
            put(8, 7);
            put(5, 1);
        }});
    }};

    static {
        selections.add(7);
        selections.add(3);
        selections.add(1);
        selections.add(5);
        selections.add(8);
        selections.add(9);
    }
//
//    public static void main(String[] args) {
//        EvaluateWin2 wm = new EvaluateWin2();
//        wm.evaluateWin();
//        System.out.println("wm.Selections: " + wm.selections);
//    }
}
