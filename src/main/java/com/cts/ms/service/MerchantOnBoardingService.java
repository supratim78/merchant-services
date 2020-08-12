package com.cts.ms.service;

import java.util.UUID;

import com.amazonaws.util.StringUtils;
import com.cts.ms.dao.MSMerchantManagementDAO;
import com.cts.ms.dao.MSMerchantOnBoardingDAO;
import com.cts.ms.dao.MerchantManagementDAO;
import com.cts.ms.dao.MerchantOnBoardingDAO;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.MerchantOnBoardingRequest;
import com.cts.ms.model.Merchants;

public class MerchantOnBoardingService implements MSMerchantOnBoardingService {

    private MSMerchantOnBoardingDAO msMerchantOnBoardingDAO;
    private MSMerchantManagementDAO msMerchantManagementDAO;

    public MerchantOnBoardingService() {
        super();
        msMerchantOnBoardingDAO = new MerchantOnBoardingDAO();
        msMerchantManagementDAO = new MerchantManagementDAO();
        
    }
    @Override
    public String validateRequestForMerchantOnBoarding(MerchantOnBoardingRequest merchantOnBoardingRequest)
            throws MSException {

        return validateRequestData(merchantOnBoardingRequest);
    }

    @Override
    public Merchants createMerchantFromOnBoardingRequest(MerchantOnBoardingRequest merchantOnBoardingRequest)
            throws MSException {

        Merchants merchant = new Merchants();
        merchant.setMid(merchantOnBoardingRequest.getRequestId());
        merchant.setSettlementCurrency(merchantOnBoardingRequest.getSettlementCurrency());
        merchant.setAcquiringBank(merchantOnBoardingRequest.getAcquiringBank());
       // merchants.setActivationDate(activationDate);
        merchant.setBankCity(merchantOnBoardingRequest.getBankCity());
        merchant.setBankCountry(merchantOnBoardingRequest.getBankCountry());
        merchant.setEmailAddress(merchantOnBoardingRequest.getEmailAddress());
        merchant.setFloatDays(merchantOnBoardingRequest.getFloatDays());
        merchant.setLegalName(merchantOnBoardingRequest.getLegalName());
        merchant.setMidTransactionLimit(merchantOnBoardingRequest.getMidTransactionLimit());
        //merchants.setMid(mid);
        merchant.setOrganizationName(merchantOnBoardingRequest.getOrganizationName());
        merchant.setPhoneNumber(merchantOnBoardingRequest.getPhoneNumber());
        merchant.setPostalCode(merchantOnBoardingRequest.getPostalCode());
        merchant.setPrimaryFundingMethod(merchantOnBoardingRequest.getPrimaryFundingMethod());
        merchant.setPurchaseCurrency(merchantOnBoardingRequest.getPurchaseCurrency());
        merchant.setState(merchantOnBoardingRequest.getState());
        merchant.setStreet(merchantOnBoardingRequest.getStreet());
        merchant.setTimeZone(merchantOnBoardingRequest.getTimeZone());
        merchant.setUrl(merchantOnBoardingRequest.getUrl());
        merchant.setMerchantName(merchantOnBoardingRequest.getMerchantName());
        return merchant;
    }

    @Override
    public String processRequestForMerchantOnBoarding(MerchantOnBoardingRequest merchantOnBoardingRequest)
            throws MSException {
        Long uniqueID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        merchantOnBoardingRequest.setRequestId(uniqueID);
        merchantOnBoardingRequest.setMidRequestStatus("STARTED");
        msMerchantOnBoardingDAO.save(merchantOnBoardingRequest);
        String message = validateRequestForMerchantOnBoarding(merchantOnBoardingRequest);
        if(StringUtils.isNullOrEmpty(message)) {
            Merchants merchant = createMerchantFromOnBoardingRequest(merchantOnBoardingRequest);
            msMerchantManagementDAO.save(merchant);
            merchantOnBoardingRequest.setMidRequestStatus("APPROVED");
            msMerchantOnBoardingDAO.update(merchantOnBoardingRequest);
            return "The new merchent has been provisioned with mid = " + merchant.getMid();
            
        }else {
            merchantOnBoardingRequest.setMidRequestStatus("REJECTED");
            msMerchantOnBoardingDAO.update(merchantOnBoardingRequest);
            return message;
        }
    }

    private String validateRequestData(MerchantOnBoardingRequest merchantOnBoardingRequest) {
        StringBuilder message = new StringBuilder("");

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getMerchantName())) {
            message.append("Merchant Name is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getOrganizationName())) {
            message.append("Organization Name is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getEmailAddress())) {
            message.append("Email Address is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getPhoneNumber())) {
            message.append("Phone Number is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getLegalName())) {
            message.append("Legal Name is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getMidTransactionLimit())) {
            message.append("Mid transaction Limit is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getPurchaseCurrency())) {
            message.append("Purchase Currency is blank. Request rejected");
        }

        if (StringUtils.isNullOrEmpty(merchantOnBoardingRequest.getSettlementCurrency())) {
            message.append("Settlement Currency is blank. Request rejected");
        }
        return message.toString();
    }

}
