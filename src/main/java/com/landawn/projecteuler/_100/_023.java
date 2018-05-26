package com.landawn.projecteuler._100;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.landawn.abacus.util.Array;
import com.landawn.abacus.util.stream.IntStream;
import com.landawn.projecteuler.TestBase;

/**
 * 
 * @see <a href="https://projecteuler.net/problem=23">Non-abundant sums</a>
 * 
 */
public class _023 extends TestBase {

    @Override
    @Test
    public void s_1() {
        final int EULER23_MAX = 28123;
        final int MAX_SQRT = (int) Math.sqrt(EULER23_MAX);

        final int[] sqrts = IntStream.rangeClosed(0, EULER23_MAX).map(i -> (int) Math.sqrt(i)).toArray();
        final int[] sums = Array.repeat(1, EULER23_MAX + 1);

        for (int i = 2; i < MAX_SQRT; i++) {
            for (int j = EULER23_MAX; sqrts[j] >= i; j--) {
                if (j % i == 0) {
                    sums[j] += (j / i == i ? i : (i + j / i));
                }
            }
        }

        final int[] abundants = IntStream.rangeClosed(1, EULER23_MAX).filter(i -> sums[i] > i).toArray();

        final Set<Integer> abundantSet = IntStream.of(abundants).toSet();

        final long result = IntStream.rangeClosed(1, EULER23_MAX) //
                .filter(i -> {
                    for (int j = 0; abundants[j] < i; j++) {
                        if (abundantSet.contains(i - abundants[j])) {
                            return false;
                        }
                    }
                    return true;
                }) //
                .sum();

        assertEquals(4179871, result);

        //    IntStream.rangeClosed(1, EULER23_MAX) //
        //            .filter(i -> IntStream.of(abundants).noneMatch(j -> abundantSet.contains(i - j))) //
        //            .max().ifPresent(i -> N.println("Actually, the max euler 23 number is: " + i));
        // Actually, the max euler 23 number is: 20161
    }

}
