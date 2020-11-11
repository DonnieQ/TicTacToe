package com.myproject;

import java.io.PrintWriter;
import java.util.Set;

public interface Gamer {
    void setName(String name);
    String getName();

    Set<Integer> getSelections();

}