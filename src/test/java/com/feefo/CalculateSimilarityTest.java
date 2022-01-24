package com.feefo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateSimilarityTest {

    @Test
    public void calculateTest() {
        CalculateSimirarity calc = new CalculateSimirarityImpl();
        float qualityScore = calc.calculate("engineer", "eenginer");
        float qsEng2 = calc.calculate("engineer", "enginerr");

        Assertions.assertEquals(.4f, qualityScore);
        Assertions.assertEquals(.9f, qsEng2);
    }
}
