package org.opencps.auth.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class APIDateTimeUtilsTest {
    @Before
    public void setUp() {
    }


    
    @Test
    public void convertNormalDateToLuceneDateTestNull() {
        String outputDateString = APIDateTimeUtils.convertNormalDateToLuceneDate(null);
        System.out.println(outputDateString);
        Assert.assertEquals(outputDateString, "");
    }
    @Test
    public void convertNormalDateToLuceneDateTestNormal() {
        String outputDateString = APIDateTimeUtils.convertNormalDateToLuceneDate("22/08/2011");
        Assert.assertEquals(outputDateString, "20110822");
    }

    @Test
    public void convertNormalDateToLuceneDateTestIncorrectFormat() {
        String outputDateString = APIDateTimeUtils.convertNormalDateToLuceneDate("2011/08/20");
        Assert.assertEquals(outputDateString, "");
    }
}
