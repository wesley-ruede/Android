package com.techyourchance.unittestingfundamentals.exercise1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class NegativeNumberValidatorTest {
    NegativeNumberValidator SUT;

    @Before
    public void setup(){
        SUT = new NegativeNumberValidator();
    }

    @Test
    public void testNegative() {
        boolean value =  SUT.isNegative(-1);
        Assert.assertThat(value,is(true));
    }

    @Test
    public void testZero() {
        boolean value = SUT.isNegative(0);
        Assert.assertThat(value,is(false));
    }

    @Test
    public void testPositive(){
        boolean value = SUT.isNegative(1);
        Assert.assertThat(value,is(false));
    }
}