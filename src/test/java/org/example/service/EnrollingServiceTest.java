package org.example.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnrollingServiceTest {
    private EnrollingService enrollingService;

    @Before
    public void init() {
        enrollingService = new EnrollingService();
    }

    @Test
    public void testEnroll() {
        boolean result = enrollingService.enroll(1L, 1L);
        assertTrue(result);
    }
}
