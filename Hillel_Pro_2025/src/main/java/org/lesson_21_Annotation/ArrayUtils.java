package org.lesson_21_Annotation;

public class ArrayUtils {
    @MethodInfo(name = "sumArray", returnType = "int", description = "sum array elements")
    @Author(firstName = "Tom", lastName = "Cruise")
    public int sumArray(int[] array) {
        int sum = 0;
        for (int n : array) {
            sum += n;
        }
        return sum;
    }

    @MethodInfo(name = "findTarget", returnType = "int", description = "find index target")
    @Author(firstName = "Robert", lastName = "De Niro")
    public int findTarget(int[] array, int target) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;

        }
        return -1;
    }
}
