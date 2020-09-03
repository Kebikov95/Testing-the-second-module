package com.hardcore.test;

import com.hardcore.model.ComputeEngine;
import com.hardcore.service.ComputeEngineCreator;
import com.hardcore.page.TenMinutesMailPage;
import com.hardcore.util.StringUtils;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WebDriverGoogleCloudPlatformPricingCalculatorPageTest extends CommonConditions {

    @Test
    public void fillingOutPriceFormTest() {
        TenMinutesMailPage mailPage = new TenMinutesMailPage(driver);
        ComputeEngine engine = ComputeEngineCreator.withOptimalParameters();
        resultPage = homePage.openGoogleCloudPlatformPricingCalculator();
        resultPage.login(engine);

        assertThat(resultPage.findNumberOfInstanceResult(),
                is(equalTo(StringUtils.getNumberOfInstanceExpectedResult(engine.getNumberOfInstances()))));
        assertThat(resultPage.findInstanceTypeResult(),
                is(equalTo(StringUtils.getInstanceTypeExpectedResult(engine.getMachineType()))));
        assertThat(resultPage.findDataCenterLocationResult(),
                is(equalTo(StringUtils.getDataCenterLocationExpectedResult(engine.getDataCenterLocation()))));
        assertThat(resultPage.findLocalSsdResult(),
                is(equalTo(StringUtils.getLocalSddExpectedResult(engine.getLocalSsd()))));
        assertThat(resultPage.findCommittedUsageResult(),
                is(equalTo(StringUtils.getCommittedUsageExpectedResult(engine.getCommittedUsage()))));
        assertThat(resultPage.findEstimatedComponentCostResult(),
                is(equalTo(StringUtils.getEstimatedComponentPartLineExpectedResult(engine.getMailTotalCost()))));
        assertThat(resultPage.getComponentCostByMail(mailPage),
                is(equalTo(StringUtils.getMailTotalCostExpectedResult(engine.getMailTotalCost()))));
    }
}
