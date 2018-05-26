package com.landawn.projecteuler;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.landawn.abacus.util.Maths.Matth;
import com.landawn.abacus.util.N;
import com.landawn.abacus.util.Profiler;
import com.landawn.abacus.util.StringUtil;

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

    public static boolean isPrime(final long n) {
        return Matth.isPrime(n);
    }

    public static boolean isPerfectNumber(final long n) {
        N.checkArgNotNegative(n, "n");

        long sum = 1;

        for (long i = (long) Math.sqrt(n); i > 1; i--) {
            if (n % i == 0) {
                if (n / i == i) {
                    sum += i;
                } else {
                    sum += (i + n / i);
                }
            }
        }

        return sum == n;
    }

    public static boolean isPerfectSquare(final long n) {
        return Matth.isPerfectSquare(n);
    }

    public static boolean isPalindrome(final int n) {
        if (n < 0) {
            return false;
        } else if (n < 10) {
            return true;
        }

        long rev = 0;
        long x = n;

        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return rev == n;
    }

    public static boolean isPalindrome(final long n) {
        if (n < 0) {
            return false;
        } else if (n <= Integer.MAX_VALUE) {
            return isPalindrome((int) n);
        }

        final String str = String.valueOf(n);

        return str.equals(StringUtil.reverse(str));
    }

    public static int gcd(final int a, final int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long gcd(final long a, final long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
