
package com.myproject;



import com.myproject.retryrule.Retry;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;


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
        assertNotEquals(0, memory.think());
    }

    public void testIfAllNumbers_AreReturned() {

    }
}