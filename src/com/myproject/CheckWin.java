package com.myproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckWin {
    public static Set<Integer> selections = new HashSet<>();
    public static List<String> winningMoves = List.of("1,2,3", "1,4,7", "1,5,9",
            "2,5,8",
            "3,6,9", "3,5,7",
            "4,5,6",
            "7,8,9");

    public boolean evaluateWin() {
        boolean condition = false;
        int count = 0;
        for (int i = 0; i < winningMoves.size(); i++, count=0) { //This runs 8 times
            String[] boxes = winningMoves.get(i).split(",");
            for (String str : boxes) { // This runs 3 times
                if (selections.contains(Integer.parseInt(str))) {
                    System.out.println("winner");
                    count++;
                } else {
                    System.out.println("false");
                }
            }
            System.out.println(Arrays.toString(boxes));
            if (count == 3 ){
                return true;
            }
//            I could have reset the counter here at the end of the loop.
        }
        return condition;
    }

    public static void main(String[] args) {
        CheckWin wm = new CheckWin();
        wm.evaluateWin();
    }


}
