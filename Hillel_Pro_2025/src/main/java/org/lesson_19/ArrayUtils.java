package org.lesson_19;

public class ArrayUtils {

    // 1) MergeSort

    public int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid1 = array.length / 2;
        int[] arr1 = new int[mid1];
        System.arraycopy(array, 0, arr1, 0, mid1);


        int mid2 = array.length - mid1;
        int[] arr2 = new int[mid2];
        System.arraycopy(array, mid1, arr2, 0, mid2);

        int[] sortArr1 = sort(arr1);
        int[] sortArr2 = sort(arr2);

        return merge(sortArr1, sortArr2);


    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int len = leftArr.length + rightArr.length;
        int[] res = new int[len];

        int i = 0; // индекс leftArr
        int j = 0; // индекс rightArr
        int k = 0; //индекс res

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                res[k] = leftArr[i];
                i++;
            } else {
                res[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            res[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            res[k] = rightArr[j];
            j++;
            k++;
        }
        return res;

    }

    // 2) BinarySearch

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            for (int i = 0; i < array.length; i++) {
                if (target == array[mid]) {
                    return mid;
                }
                if (target > array[mid]) {
                    left = mid + 1;
                } else right = mid - 1;

            }

        }
        return -1;
    }
}
