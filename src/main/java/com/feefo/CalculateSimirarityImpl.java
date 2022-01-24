package com.feefo;

import java.text.DecimalFormat;

public class CalculateSimirarityImpl implements CalculateSimirarity {
    DecimalFormat df = new DecimalFormat("#.#");

    public float calculate(String jobTitle, String search) {
        float total = jobTitle.length();
        float notSimilarity = 0;

        for(int i=0;i<jobTitle.length();i++) {
            if(String.valueOf(jobTitle.toLowerCase().charAt(i)).equals(String.valueOf(search.toLowerCase().charAt(i)))) {
                continue;
            }
            notSimilarity++;
        }
        String result = df.format((notSimilarity / total) - 1);
        return Math.abs(Float.valueOf(result));
    }
}
