package com.feefo;

public class WordImpl implements Word {
    public String generateCompoundWord(String word) {
        return word.trim() + " " + word.trim();
    }

    public String transformString(String target, String word) {
        int biggestLengthWord = target.length() > word.length() ? target.length() : word.length();
        int pointer = word.length() - 1;
        int jobWordPointer = biggestLengthWord - 1;
        char[] newWord = new char[biggestLengthWord];

        for (int i = 0; i < biggestLengthWord; i++) {
            if (i < word.length()) {
                newWord[i] = word.charAt(i);
                continue;
            }
            newWord[jobWordPointer--] = word.charAt(pointer--);
            if (pointer == -1) {
                pointer = word.length() - 1;
            }
        }

        return String.valueOf(newWord);
    }

    public String reverseTransformString(String target, String word) {
        int biggestLengthWord = target.length() > word.length() ? target.length() : word.length();
        int pointer = 0;
        int jobWordPointer = word.length() - 1;
        char[] newWord = new char[biggestLengthWord];

        for (int i = biggestLengthWord - 1; i >= 0; i--) {
            if ((i + word.length()) >= biggestLengthWord) {
                newWord[i] = word.charAt(jobWordPointer--);
                continue;
            }
            if (jobWordPointer < 0 || jobWordPointer >= word.length()) {
                jobWordPointer = 0;
            }
            newWord[pointer++] = word.charAt(jobWordPointer++);
        }
        return String.valueOf(newWord);
    }
}
