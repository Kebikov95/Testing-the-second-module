package com.hardcore.test;

import com.hardcore.model.ComputeEngine;
import com.hardcore.service.ComputeEngineCreator;
import com.hardcore.page.TenMinutesMailPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WebDriverGoogleCloudPlatformPricingCalculatorPageTest extends CommonConditions {
    private String NUMBER_OF_INSTANCE_EXPECTED_RESULT = "4 x";
    private String MACHINE_CLASS_EXPECTED_RESULT = "VM class: regular";
    private String INSTANCE_TYPE_EXPECTED_RESULT = "Instance type: n1-standard-8";
    private String DATA_CENTER_LOCATION_EXPECTED_RESULT = "Region: Frankfurt";
    private String LOCAL_SSD_EXPECTED_RESULT = "Total available local SSD space 2x375 GiB";
    private String COMMITTED_USAGE_EXPECTED_RESULT = "Commitment term: 1 Year";
    private String ESTIMATED_COMPONENT_COST_EXPECTED_RESULT = "Estimated Component Cost: USD 1,082.77 per 1 month";
    private String MAIL_TOTAL_COST_EXPECTED_RESULT = "USD 1,082.77";

    @Test
    public void fillingOutPriceFormTest() {
        TenMinutesMailPage mailPage = new TenMinutesMailPage(driver);
        ComputeEngine engine = ComputeEngineCreator.withOptimalParameters();
        resultPage = homePage.openGoogleCloudPlatformPricingCalculator();
        resultPage.login(engine);

        assertThat(resultPage.findNumberOfInstanceResult(), is(equalTo(NUMBER_OF_INSTANCE_EXPECTED_RESULT)));
        assertThat(resultPage.findMachineClassResult(), is(equalTo(MACHINE_CLASS_EXPECTED_RESULT)));
        assertThat(resultPage.findInstanceTypeResult(), is(equalTo(INSTANCE_TYPE_EXPECTED_RESULT)));
        assertThat(resultPage.findDataCenterLocationResult(), is(equalTo(DATA_CENTER_LOCATION_EXPECTED_RESULT)));
        assertThat(resultPage.findLocalSsdResult(), is(equalTo(LOCAL_SSD_EXPECTED_RESULT)));
        assertThat(resultPage.findCommittedUsageResult(), is(equalTo(COMMITTED_USAGE_EXPECTED_RESULT)));
        assertThat(resultPage.findEstimatedComponentCostResult(), is(equalTo(ESTIMATED_COMPONENT_COST_EXPECTED_RESULT)));
        assertThat(resultPage.getComponentCostByMail(mailPage), is(equalTo(MAIL_TOTAL_COST_EXPECTED_RESULT)));
    }
}
