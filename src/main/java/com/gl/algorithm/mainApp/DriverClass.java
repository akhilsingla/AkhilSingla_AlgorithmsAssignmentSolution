package com.gl.algorithm.mainApp;

import com.gl.algorithm.processStockInfo.ProcessStockInfo;

public class DriverClass
{
    public static void main(String[] args)
    {
        ProcessStockInfo processStockInfo = new ProcessStockInfo();
        processStockInfo.getInputFromUserAndCompute();
    }
}
