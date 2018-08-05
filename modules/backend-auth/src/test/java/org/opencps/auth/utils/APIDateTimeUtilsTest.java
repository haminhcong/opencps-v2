package org.opencps.auth.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class APIDateTimeUtilsTest {
    @Before
    public void setUp() {
    }


    
    @Test
    public void convertNormalDateToLuceneDateTest() {
        String outputDateString = APIDateTimeUtils.convertNormalDateToLuceneDate(null);
        Assert.assertEquals(outputDateString, "1");
    }
}
