package com.cts.ms.handler;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.ms.TestContext;
import com.cts.ms.model.ApiGatewayResponse;
import com.cts.ms.model.MerchantOnBoardingRequest;
import com.cts.ms.service.MSMerchantOnBoardingService;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class TestSubmitMerchantOnBoardingRequestHandler {

    private static Map<String, Object> input;
    @Mock
    private MSMerchantOnBoardingService msMerchantOnBoardingService;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = null;
        final String jsonString = "{\n" + 
                "  \"merchantName\": \"Faredeal santoshpur\",\n" + 
                "  \"organizationName\": \"Faredeal p.v.t l.t.d\",\n" + 
                "  \"street\": \"Santoshpur Avenue\",\n" + 
                "  \"city\":\"Kolkata\",\n" + 
                "  \"state\":\"West Bengal\",\n" + 
                "  \"country\":\"India\",\n" + 
                "  \"postalCode\":\"700075\",\n" + 
                "  \"emailAddress\": \"supratim78@gmail.com\",\n" + 
                "  \"url\":\"www.faredeal.com\",\n" + 
                "  \"phoneNumber\": \"9876543210\",\n" + 
                "  \"legalName\": \"Faredeal\",\n" + 
                "  \"midTransactionLimit\": \"200\",\n" + 
                "  \"purchaseCurrency\": \"INR\",\n" + 
                "  \"settlementCurrency\": \"INR\",\n" + 
                "  \"primaryFundingMethod\":\"XYZ\",\n" + 
                "  \"bankCity\":\"Kolkata\",\n" + 
                "  \"bankCountry\":\"India\",\n" + 
                "  \"billingProfileName\":\"Faredeal\",\n" + 
                "  \"timeZone\":\"IST\",\n" + 
                "  \"floatDays\":\"12\",\n" + 
                "  \"acquiringBank\":\"fifththird\"\n" + 
                "}";
        input = new HashMap<String, Object>();
        input.put("body", jsonString);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testHandleRequest() throws Exception {

        SubmitMerchantOnBoardingRequestHandler handler = new SubmitMerchantOnBoardingRequestHandler();
        MerchantOnBoardingRequest merchantOnBoardingRequest = handler.parseJsonRequestBody(input, MerchantOnBoardingRequest.class);
        Field reader = SubmitMerchantOnBoardingRequestHandler.class.getDeclaredField("msMerchantOnBoardingService");
        reader.setAccessible(true);
        msMerchantOnBoardingService = Mockito.mock(MSMerchantOnBoardingService.class);
        Mockito.when(msMerchantOnBoardingService.processRequestForMerchantOnBoarding(merchantOnBoardingRequest)).thenReturn("provisioned");
        reader.set(handler, msMerchantOnBoardingService);
        Context ctx = createContext();
        

        ApiGatewayResponse response = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals(200, response.getStatusCode());
    }
}
