package com.gl.algorithm.processStockInfo;

public class BinarySearch
{
    public boolean binarySearch(double[] arr, double valueToSearch, int lowIndex, int highIndex)
    {
        if(highIndex < lowIndex)
            return false;

        int middleIndex = lowIndex + (highIndex - lowIndex)/2;
        if(arr[middleIndex] == valueToSearch)
            return true;

        if(arr[middleIndex] > valueToSearch)
            return binarySearch(arr, valueToSearch, lowIndex, middleIndex-1);
        else
            return binarySearch(arr, valueToSearch, middleIndex+1, highIndex);
    }
}
