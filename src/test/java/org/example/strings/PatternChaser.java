package org.example.strings;

public class PatternChaser {

    public static void main(String[] args) {
        System.out.println(patternChaser("aa2bbbaacbbb"));
        System.out.println(patternChaser("aabecaa"));
        System.out.println(patternChaser("123224"));
        System.out.println(patternChaser("abcdefgh"));
        System.out.println(patternChaser("da2kr32a2"));
        System.out.println(patternChaser("sskfssbbb9bbb"));
        System.out.println(patternChaser("sskfssbbb9bbb"));
    }

    private static String patternChaser(String str) {
        String pattern = null;
        int patternCount;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subStr = str.substring(i, j + 1);
                patternCount = 1;

                for (int k = 0; k < str.length() - subStr.length() + 1; k++) {
                    if (k == i) continue;
                    if (subStr.equals(str.substring(k, k + subStr.length()))) {
                        patternCount++;
                    }
                }

                if (patternCount >= 2 && (pattern == null || pattern.length() < subStr.length())) {
                    pattern = subStr;
                }
            }
        }
        return pattern != null ? STR."yes \{pattern}" : "no null";
    }
}
