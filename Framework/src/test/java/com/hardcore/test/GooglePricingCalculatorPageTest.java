package com.hardcore.test;

import com.hardcore.model.ComputeEngine;
import com.hardcore.service.ComputeEngineCreator;
import com.hardcore.page.TenMinutesMailPage;
import com.hardcore.util.StringUtils;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GooglePricingCalculatorPageTest extends CommonConditions {
    private ComputeEngine engine;

    @BeforeClass
    public void login() {
        engine = ComputeEngineCreator.createComputeEngine();
        resultPage = homePage.openGoogleCloudPlatformPricingCalculator();
        resultPage.login(ComputeEngineCreator.createComputeEngine());
    }

    @Test
    public void assertNumberOfInstanceResult() {
        assertThat(resultPage.findNumberOfInstanceResult(),
                is(equalTo(StringUtils.getNumberOfInstanceExpectedResult(engine.getNumberOfInstances()))));
    }

    @Test
    public void assertInstanceTypeResult() {
        assertThat(resultPage.findInstanceTypeResult(),
                is(equalTo(StringUtils.getInstanceTypeExpectedResult(engine.getMachineType()))));
    }

    @Test
    public void assertDataCenterLocationResult() {
        assertThat(resultPage.findDataCenterLocationResult(),
                is(equalTo(StringUtils.getDataCenterLocationExpectedResult(engine.getDataCenterLocation()))));
    }

    @Test
    public void assertLocalSsdResult() {
        assertThat(resultPage.findLocalSsdResult(),
                is(equalTo(StringUtils.getLocalSddExpectedResult(engine.getLocalSsd()))));
    }

    @Test
    public void assertCommittedUsageResult() {
        assertThat(resultPage.findCommittedUsageResult(),
                is(equalTo(StringUtils.getCommittedUsageExpectedResult(engine.getCommittedUsage()))));
    }

    @Test
    public void assertTotalPriceSentByMail() {
        TenMinutesMailPage mailPage = new TenMinutesMailPage(driver);
        assertThat(resultPage.getComponentCostByMail(mailPage),
                is(equalTo(StringUtils.getMailTotalCostExpectedResult(engine.getMailTotalCost()))));
    }
}
