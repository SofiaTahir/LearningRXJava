package com.example.learningrxjava;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class UtilTest {

    @Test
    public void emptyStringreturnsTrue(){
        boolean val = Util.checkStringEmpty("");
        assertThat(val).isTrue();
    }
    @Test
    public void NonEmptyStringreturnsFalse(){
        boolean val = Util.checkStringEmpty("123");
        assertThat(val).isFalse();
    }
    @Test
    public void ValidIDreturnsFalse(){
        boolean val = Util.checkIDValid(2);
        assertThat(val).isTrue();
    }
    @Test
    public void InValidIDreturnsFalse(){
        boolean val = Util.checkIDValid(0);
        assertThat(val).isFalse();
    }



}