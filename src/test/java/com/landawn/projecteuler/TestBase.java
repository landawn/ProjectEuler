package com.landawn.projecteuler;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.landawn.abacus.util.Profiler;

public abstract class TestBase {

    /**
     * Solution 1
     */
    @Test
    public abstract void s_1();

    /**
     * Solution 2
     */
    @Test
    public void s_2() {
        fail("Not yet implemented");
    }

    /**
     * Solution 3
     */
    @Test
    public void s_3() {
        fail("Not yet implemented");
    }

    @Test
    public void perf_1() {
        Profiler.run(1, 100, 3, () -> s_1());
    }
}
