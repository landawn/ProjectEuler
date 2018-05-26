package com.landawn.projecteuler._100;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.landawn.abacus.util.N;
import com.landawn.projecteuler.TestBase;

/**
 * 
 * @see <a href="https://projecteuler.net/problem=4">Largest palindrome product</a>
 * 
 */
public class _004 extends TestBase {

    @Override
    @Test
    public void s_1() {
        int result = 0;

        for (int p = 990; p > 99; p -= 11) {

            for (int q = 999; q > 99; q--) {

                int t = p * q;

                if (result < t && isPalindrome(t)) {
                    result = t;
                    break;
                } else if (t < result) {
                    break;
                }
            }
        }

        N.println(result);

        assertEquals(998899, result);
    }

    @Override
    @Test
    public void s_2() {
        int max = 100001;

        for (int i = 999; i >= 100; i--) {
            if (max >= i * 999) {
                break;
            }
            for (int j = 999; j >= i; j--) {
                int p = i * j;
                if (max < p && isPalindrome(p)) {
                    max = p;
                }
            }
        }

        N.println(max);
    }
}
