package com.ss.may21.week1;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class RightDigitTest {
    @Test
    public void rightDigit() {
        // rightDigit([1, 22, 93]) → [1, 2, 3]
        // rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
        // rightDigit([10, 0]) → [0, 0]
        assertEquals(Arrays.asList(1, 2, 3), RightDigit.rightDigit(Arrays.asList(1, 22, 93)));
        assertNotEquals(Arrays.asList(1, 2, 4), RightDigit.rightDigit(Arrays.asList(111, 222, 333)));
    }
}
