package com.myproject;

import com.myproject.retryrule.Retry;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class ComputerBrainTest{
    ComputerBrain memory;
    @Rule
    public Retry retry = new Retry(10);


    @Before
    public void setUp() {
        memory = new ComputerBrain();
    }

    @Test
    public void testIfComputerReturns_validRanges() {
        ComputerBrain memory = new ComputerBrain();
        memory.think();
        System.out.println("x");


    }

    public void testIfAllNumbers_AreReturned() {

    }
}