package com.feefo;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Normalizer {
    private final List<String> jobList = Arrays.asList("Architect", "Software engineer", "Quantity surveyor", "Accountant");
    private Word word = new WordImpl();
    private CalculateSimirarity calculateSimirarity = new CalculateSimirarityImpl();

    public Normalizer() {}

    public Normalizer(CalculateSimirarity calculateSimirarity) {
        this.calculateSimirarity = calculateSimirarity;
    }

    public Normalizer(Word word) {
        this.word = word;
    }

    public Normalizer(Word word, CalculateSimirarity calculateSimirarity) {
        this.word = word;
        this.calculateSimirarity = calculateSimirarity;
    }

    public String normalize(String job) {
        float mostScored = 0f;
        String result = "Job not found";
        for (String jobBase : jobList) {
            float score = calculateSimilarity(jobBase.toLowerCase(), job.toLowerCase());
            if (score > mostScored && score > .5f) {
                mostScored = score;
                result = jobBase;
            }
        }
        return result;
    }

    public float calculateSimilarity(String jobBase, String jobSearch) {
        String[] baseWords = jobBase.split(" ");
        String[] searchWords = jobSearch.split(" ");
        float calc = 0;
        boolean equalWords = false;

        if (baseWords.length < searchWords.length) {
            baseWords = this.word.generateCompoundWord(baseWords[0]).split(" ");
        }

        for (int i = 0; i < searchWords.length; i++) {
            String search = searchWords[i];
            if (baseWords[i].length() != searchWords[i].length()) {
                String reverseTransform = this.word.reverseTransformString(baseWords[i], searchWords[i]);
                search = this.word.transformString(baseWords[i], searchWords[i]);
                calc += this.calculateSimirarity.calculate(baseWords[i], reverseTransform);
                if (baseWords[i].equals(reverseTransform)) {
                    equalWords = true;
                }
            }
            calc += this.calculateSimirarity.calculate(baseWords[i], search);
            if (baseWords[i].equals(search)) {
                equalWords = true;
            }
            if (equalWords) {
                calc += 2;
            }
        }
        return calc / (Float.valueOf(searchWords.length) * (jobBase.length() == jobSearch.length() ? 1 : 2));
    }
}
