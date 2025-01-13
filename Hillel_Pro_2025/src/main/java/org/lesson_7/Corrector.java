package org.lesson_7;

public class Corrector {
    public String handleData(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (String str : strs) {

            str = str.replace("b", "o");

            count++;
            stringBuilder.append(count).append(") ").append(str).append("\n");
        }
        return stringBuilder.toString();
    }
}
