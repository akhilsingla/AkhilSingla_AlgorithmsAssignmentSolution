package com.gl.algorithm.processStockInfo;

public class MergeSort {

    private double[] nums;
    private double[] tempArray;

    public MergeSort(double[] nums) {
        this.nums = nums;
        this.tempArray = new double[nums.length];
    }

    public double[] sort(boolean ascending) {
        mergeSort(0, nums.length - 1, ascending);
        return nums;
    }

    private void mergeSort(int low, int high, boolean ascending) {

        // base-case
        if (low >= high)
            return;

        // middle item
        int middleIndex = (low + high) / 2;

        // we keep splitting the problem into smaller and smaller sub-problems
        // until a given array contains just 1 item
        mergeSort(low, middleIndex, ascending);
        mergeSort(middleIndex + 1, high, ascending);

        // we have to combine the sub-solutions
        merge(low, middleIndex, high, ascending);
    }

    private void merge(int low, int middle, int high, boolean ascending) {

        // copy the items into the temporary array
        for (int i = low; i <= high; ++i)
            tempArray[i] = nums[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        // we consider the temp array and copy the items into the nums
        // sorting based upon parameter "ascending"
        while (i <= middle && j <= high) {
            if (ascending) {
                if (tempArray[i] < tempArray[j]) {
                    nums[k] = tempArray[i];
                    ++i;
                } else {
                    nums[k] = tempArray[j];
                    ++j;
                }
            } else {
                if (tempArray[i] > tempArray[j]) {
                    nums[k] = tempArray[i];
                    ++i;
                } else {
                    nums[k] = tempArray[j];
                    ++j;
                }
            }

            ++k;
        }

        // we have to copy the items from the left sub-array (if there are any)
        while (i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }

        // we have to copy the items from the right sub-array (if there are any)
        while (j <= high) {
            nums[k] = tempArray[j];
            ++k;
            ++j;
        }
    }
}