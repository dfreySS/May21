package com.ss.may21.week1;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class StringRemoveXTest {
    @Test
    public void noX () {
        assertEquals(Arrays.asList("a", "b", "c"), StringRemoveX.noX(Arrays.asList("xax", "bx", "xc")));
        assertNotEquals(Arrays.asList("x", "1", "2"), StringRemoveX.noX(Arrays.asList("x", "1xxx", "x2xx")));
    }
}
