package com.landawn.projecteuler._100;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.landawn.abacus.util.stream.IntStream;
import com.landawn.projecteuler.TestBase;

/**
 * 
 * @see <a href="https://projecteuler.net/problem=1">Multiples of 3 and 5</a>
 * 
 */
public class _001 extends TestBase {

    @Override
    @Test
    public void s_1() {
        long result = IntStream.range(0, 1000).filter(e -> e % 3 == 0 || e % 5 == 0).sum();
        assertEquals(233168, result);
    }

    @Override
    @Test
    public void s_2() {
        long result = IntStream.rangeClosed(0, 999 / 3).map(i -> i * 3).sum();
        result = result + IntStream.rangeClosed(0, 999 / 5).map(i -> i * 5).sum();
        result = result - IntStream.rangeClosed(0, 999 / 15).map(i -> i * 15).sum();

        assertEquals(233168, result);
    }
}
