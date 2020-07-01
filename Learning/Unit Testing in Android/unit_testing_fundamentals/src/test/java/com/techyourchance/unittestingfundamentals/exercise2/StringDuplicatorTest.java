package com.techyourchance.unittestingfundamentals.exercise2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringDuplicatorTest {
    StringDuplicator SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new StringDuplicator();
    }

    @Test
    public void stringDuplicator_emptyString_returnsEmptyString() throws Exception {
        String value =  SUT.duplicate("");
        assertThat(value, is(""));
    }

    @Test
    public void stringDuplicator_stringDuplication_returnsDuplicatedString() throws Exception {
        String value = SUT.duplicate("b") ;
        assertThat(value,is("bb"));
    }
}