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
        final long n = 600851475143L;
        int result = 1;

        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            if (n % i == 0 && isPrime(i)) {
                result = i;
                break;
            }
        }

        assertEquals(6857, result);
    }
}
