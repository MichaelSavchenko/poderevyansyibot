package com.mihadev.poderevjanskyibot.play;

public class MergeSort {

    public static void mergeSort(int[] initialArray) {

        int initialArrayLength = initialArray.length;

        if (initialArrayLength < 2) {
            return;
        }

        int middleIndex = initialArrayLength / 2;

        int[] left = new int[middleIndex];
        int rightArrayLength = initialArrayLength - middleIndex;
        int[] right = new int[rightArrayLength];

        System.arraycopy(initialArray, 0, left, 0, middleIndex);
        System.arraycopy(initialArray, middleIndex, right, 0, rightArrayLength);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, initialArray);
    }

    private static void merge(int[] left, int[] right, int[] initialArray) {

        int mergedArrayLength = left.length + right.length;

        int leftArrayIndex = 0, rightArrayIndex = 0;

        for (int mergedArrayIndex = 0; mergedArrayIndex < mergedArrayLength; mergedArrayIndex++) {

            if (rightArrayIndex >= right.length || leftArrayIndex < left.length && left[leftArrayIndex] < right[rightArrayIndex]) {
                initialArray[mergedArrayIndex] = left[leftArrayIndex];
                leftArrayIndex++;
            } else {
                initialArray[mergedArrayIndex] = right[rightArrayIndex];
                rightArrayIndex++;
            }
        }
    }
}
