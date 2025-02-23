package com.datarepublic;

import org.testng.IExecutionListener;

public class TestNGExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG is staring the execution");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Generating the HTML Report");
        GenerateReport.GenerateMasterthoughtReport();
        System.out.println("TestNG has finished the execution");
    }
}
