package com.sample.utility;

import org.slf4j.Logger;
import org.testng.IExecutionListener;

/**
 * Created by Mahesh Bhosale
 */
public class TestNgExecutionListener extends LogConfig implements IExecutionListener {

    Logger logger = getLogger();

    @Override
    public void onExecutionStart() {
        logger.info("TestNG is staring the execution");
    }

    @Override
    public void onExecutionFinish() {
        logger.info("Generating the Masterthought Report");
        GenerateReport.GenerateMasterthoughtReport();
        logger.info("TestNG has finished, the execution");
    }
}