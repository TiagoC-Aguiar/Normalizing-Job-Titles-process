package com.feefo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {
    @Test
    public void transformStringTest() {
        WordImpl w = new WordImpl();
        String jt = "Java";
        String target = "Software";
        String newWord = w.transformString(target, jt);

        jt = "C#";
        target = "Software";
        String newWord2 = w.transformString(target, jt);

        jt = "Acountant";
        target = "Accountant";
        String newWord3 = w.transformString(target, jt);

        jt = "surveor";
        target = "surveyor";
        String newWord4 = w.transformString(target, jt);

        Assertions.assertEquals("JavaJava", newWord);
        Assertions.assertEquals("C#C#C#C#", newWord2);
        Assertions.assertEquals("Acountantt", newWord3);
        Assertions.assertEquals("surveorr", newWord4);
    }

    @Test
    public void reverseTransformStringTest() {
        WordImpl w = new WordImpl();
        String jt = "Java";
        String target = "Software";
        String newWord = w.reverseTransformString(target, jt);

        jt = "Acount";
        target = "Account";
        String newWord3 = w.reverseTransformString(target, jt);

        jt = "surveor";
        target = "surveyor";
        String newWord4 = w.reverseTransformString(target, jt);

        jt = "engener";
        target = "engineer";
        String newWord5 = w.reverseTransformString(target, jt);

        jt = "Chief";
        target = "Accountant";
        String newWord6 = w.reverseTransformString(target, jt);

        jt = "Java";
        target = "Architect";
        String newWord7 = w.reverseTransformString(target, jt);

        Assertions.assertEquals("JavaJava", newWord);
        Assertions.assertEquals("AAcount", newWord3);
        Assertions.assertEquals("ssurveor", newWord4);
        Assertions.assertEquals("eengener", newWord5);
        Assertions.assertEquals("ChiefChief", newWord6);
        Assertions.assertEquals("JavaJJava", newWord7);
    }

    @Test
    public void generateCompoundWordTest() {
        WordImpl w = new WordImpl();
        String word = "Engineer";
        String compundWord = w.generateCompoundWord(word);

        word = "Accountant ";
        String compundWord2 = w.generateCompoundWord(word);

        Assertions.assertEquals("Engineer Engineer", compundWord);
        Assertions.assertEquals("Accountant Accountant", compundWord2);
    }
}
