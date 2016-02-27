package com.guzichenko;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Артем on 26.02.2016.
 */
public class FileStatTest {

    ArrayList<LineStat> list = new ArrayList<>();

    @Before
    public void setList() {

        list.add( new LineStat("test01 longest test02"));
        list.add( new LineStat("test03 short test04"));
        list.add( new LineStat("test05 test06 test07"));

    }

    @Test
     public void testGetMaxLength(){
        FileStat fs = new FileStat(list);
        assertEquals("longest", fs.getMaxLength());
    }

    @Test
    public void testGetMinLength(){
        FileStat fs = new FileStat(list);
        assertEquals("short", fs.getMinLength());
    }

    @Test
    public void testGetLineLength(){
        FileStat fs = new FileStat(list);
        assertEquals(60, fs.getLineLength());
    }
    @Test
    public void testGetAverageWordLength(){
        FileStat fs = new FileStat(list);
        assertEquals(6.0, fs.getAverageWordLength(), 1e-5);
    }


}
