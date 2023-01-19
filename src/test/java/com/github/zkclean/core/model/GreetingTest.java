package com.github.zkclean.core.model;

import com.github.zkclean.core.model.greeting.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
    References:
    ----------

    1.  Baeldung, JUnit 5: https://www.baeldung.com/parameterized-tests-junit-5
 */

/**
 * Unit tests for {@link Greeting} domain value object.
 */
public class GreetingTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "\t", "\n", " "})
    void must_not_create_greeting_with_null_or_blank_message(String message) {
        Assertions.assertThrows(InvalidDomainObjectError.class, () -> Greeting.builder()
                .message(message)
                .build());
    }
}
