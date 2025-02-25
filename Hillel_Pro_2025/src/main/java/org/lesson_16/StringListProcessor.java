package org.lesson_16;

public class StringListProcessor {

    public static int countUppercase(String str) {

        int count = 0;
        for (char upLet : str.toCharArray()) {
            if (Character.isUpperCase(upLet)) {
                count++;
            }
        }
        return count;

    }
}
