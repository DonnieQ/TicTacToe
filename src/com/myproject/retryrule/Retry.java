package com.myproject.retryrule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Retry implements TestRule {

    private final int retryCount;

    public Retry(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Statement apply(final Statement base,
                           final Description description) {
        // intelliJ added this..why
        return new Statement() {

            @Override
            public void evaluate() {
                for (int i = 0; i < retryCount; i++) {      //retry loop
                    try {
                        base.evaluate();  // calls test method

                    } catch (Throwable t) {
                        System.err.println(description.getDisplayName()
                                + (i + 1) );
                        t.printStackTrace();
                    }
                }

            }
        };
    }
}