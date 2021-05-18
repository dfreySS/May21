package com.ss.may21.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MultByTwoTest {
    @Test
    public void doubling() {
        assertEquals(Arrays.asList(2, 4, 6), MultByTwo.doubling(Arrays.asList(1, 2, 3)));
        assertNotEquals(Arrays.asList(12, 16, -1), MultByTwo.doubling(Arrays.asList(6, 8, -1)));
    }
}