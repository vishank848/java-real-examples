package org.example;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSabreTest {
    private final TestSabre testSabre = new TestSabre();
    
    @Test
    void test_whenStringIsEmpty() {
        Assertions.assertThat(testSabre.printOccurrence("")).containsKeys("empty or null string");
    }

    @Test
    void test_whenStringIsNull() {
        Assertions.assertThat(testSabre.printOccurrence(null)).containsKeys("empty or null string");
    }

    @Test
    void test_whenStringIsPresent() {
        Assertions.assertThat(testSabre.printOccurrence("ASASWEFDFasaa"))
            .containsAllEntriesOf(Map.of("a", 3L));
    }
}