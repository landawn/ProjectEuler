package com.landawn.projecteuler._100;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.landawn.projecteuler.TestBase;

/**
 * 
 * @see <a href="https://projecteuler.net/problem=3">Largest prime factor</a>
 * 
 */
public class _003 extends TestBase {

    @Override
    @Test
    public void s_1() {
        int result = 0;

        int num1 = 1;
        int num2 = 1;
        int next = num1 + num2;

        while (next < 4000_001) {
            if (next % 2 == 0) {
                result += next;
            }

            num1 = num2;
            num2 = next;
            next = num1 + num2;
        }

        assertEquals(4613732, result);
    }
}
