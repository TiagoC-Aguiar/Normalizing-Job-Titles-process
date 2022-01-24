package com.feefo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NormalizerTest {

    @Test
    public void normaliseTest() {
        Normalizer n = new Normalizer();
        String jt = "Java engineer";
        String javaEng = n.normalize(jt);
        jt = "C# engineer";
        String csEng = n.normalize(jt);
        jt = "Chief accountant";
        String chiefAccount = n.normalize(jt);
        jt = "Accountant";
        String chiefAccount2 = n.normalize(jt);
        jt = "Marketing Manager";
        String manager = n.normalize(jt);

        Assertions.assertEquals("Software engineer", javaEng);
        Assertions.assertEquals("Software engineer", csEng);
        Assertions.assertEquals("Accountant", chiefAccount);
        Assertions.assertEquals("Accountant", chiefAccount2);
        Assertions.assertEquals("Job not found", manager);
    }

    @Test
    public void calculateSimilarityTest() {
        WordImpl w = new WordImpl();
        CalculateSimirarity cs = new CalculateSimirarityImpl();
        Normalizer n = new Normalizer(w, cs);
        String jt = "Accountant";
        float calcAccount = n.calculateSimilarity("accountant", jt);

        jt = "Acountant";
        float calcAccount2 = n.calculateSimilarity("accountant", jt);

        jt = "Java engineer";
        float calcAccount3 = n.calculateSimilarity("Software engineer", jt);

        Assertions.assertEquals(1f, calcAccount);
        Assertions.assertEquals(.6f, calcAccount2);
        Assertions.assertEquals(.8f, calcAccount3);
    }
}
