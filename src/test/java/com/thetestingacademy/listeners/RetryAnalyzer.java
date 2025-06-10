package com.thetestingacademy.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int max_retryCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < max_retryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
