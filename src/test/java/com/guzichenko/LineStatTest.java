package com.guzichenko;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Артем on 26.02.2016.
 */
public class LineStatTest {

    @Test
    public void testMaxLength() throws Exception{
        LineStat ls = new LineStat("Longest short");
        assertEquals("Longest", ls.getMaxLength());
    }

    @Test
    public void testMinLength() throws Exception{
        LineStat ls = new LineStat("Longest short");
        assertEquals("short", ls.getMinLength());
    }

    @Test
    public void testLineLength() throws Exception{
        LineStat ls = new LineStat("123456789");
        assertEquals(9, ls.getLineLength());
    }

    @Test
    public void testAverageWordLength() throws Exception{
        LineStat ls = new LineStat("123 12 123 32");
        assertEquals(2.5, ls.getAverageWordLength(), 1e-5);
    }




}
