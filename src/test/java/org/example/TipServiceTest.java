package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TipServiceTest {
    private TipService tipService = new TipService();
    @ParameterizedTest
    @CsvSource({
            "700, 1.1",
            "0, 1.1",
            "-30, 1.1",
            "1000, 1.05",
            "1111, 1.05"
    })
    public void testRoundTips(BigDecimal amount, BigDecimal percent) {
        BigDecimal expected = amount.multiply(percent);
        BigDecimal actual = tipService.roundTips(amount);
        assertEquals(expected, actual);
    }
}
