package com.bon.sand;

import org.junit.Test;

public class PersonTest {

    @Test(expected = NullPointerException.class)
    public void should_throw_error_for_null_name() {
        new Child(null);
    }
}
