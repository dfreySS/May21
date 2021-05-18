package com.ss.may21.week1;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SumClumpTest {
    @Test
    public void groupClumpSum() {
        assertTrue(SumClump.groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14));
        assertFalse(SumClump.groupSumClump(0, new int[]{2, 4, 4, 8}, 14));
    }
}
