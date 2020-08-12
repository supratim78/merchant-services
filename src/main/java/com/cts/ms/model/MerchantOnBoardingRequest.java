package com.cts.ms.model;

import org.apache.log4j.Logger;

import com.cts.ms.dao.DynamoDBAdapter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

@DynamoDBTable(tableName = "PLACEHOLDER_MERCHANTS_ONBOARDING_REQUEST_TABLE_NAME")
public class MerchantOnBoardingRequest {

    private Logger logger = Logger.getLogger(this.getClass());

    private long requestId;
    private String merchantName;
    private String organizationName;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String emailAddress;
    private String url;
    private String phoneNumber;
    private String legalName;
    private String midRequestStatus;
    private String midTransactionLimit;
    private String purchaseCurrency;
    private String settlementCurrency;
    private String primaryFundingMethod;
    private String bankCity;
    private String bankCountry;
    private String billingProfileName;
    private String timeZone;
    private long floatDays;
    private String acquiringBank;
    private String createDate;

    @DynamoDBHashKey(attributeName = "requestId")
//    @DynamoDBAutoGeneratedKey
    public long getRequestId() {
        return requestId;
    }
    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    @JsonProperty("merchantName")
    @DynamoDBAttribute(attributeName = "merchantName")
    public String getMerchantName() {
        return merchantName;
    }
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @DynamoDBAttribute(attributeName = "organizationName")
    @JsonProperty("organizationName")
    public String getOrganizationName() {
        return organizationName;
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @DynamoDBAttribute(attributeName = "street")
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @DynamoDBAttribute(attributeName = "city")
    @JsonProperty("city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @DynamoDBAttribute(attributeName = "state")
    @JsonProperty("state")
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("country")
    @DynamoDBAttribute(attributeName = "country")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("postalCode")
    @DynamoDBAttribute(attributeName = "postalCode")
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("emailAddress")
    @DynamoDBAttribute(attributeName = "emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("url")
    @DynamoDBAttribute(attributeName = "url")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("phoneNumber")
    @DynamoDBAttribute(attributeName = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("legalName")
    @DynamoDBAttribute(attributeName = "legalName")
    public String getLegalName() {
        return legalName;
    }
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    @DynamoDBAttribute(attributeName = "midRequestStatus")
    public String getMidRequestStatus() {
        return midRequestStatus;
    }
    public void setMidRequestStatus(String midRequestStatus) {
        this.midRequestStatus = midRequestStatus;
    }

    @JsonProperty("midTransactionLimit")
    @DynamoDBAttribute(attributeName = "midTransactionLimit")
    public String getMidTransactionLimit() {
        return midTransactionLimit;
    }
    public void setMidTransactionLimit(String midTransactionLimit) {
        this.midTransactionLimit = midTransactionLimit;
    }

    @JsonProperty("purchaseCurrency")
    @DynamoDBAttribute(attributeName = "purchaseCurrency")
    public String getPurchaseCurrency() {
        return purchaseCurrency;
    }
    public void setPurchaseCurrency(String purchaseCurrency) {
        this.purchaseCurrency = purchaseCurrency;
    }

    @JsonProperty("settlementCurrency")
    @DynamoDBAttribute(attributeName = "settlementCurrency")
    public String getSettlementCurrency() {
        return settlementCurrency;
    }
    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    @JsonProperty("primaryFundingMethod")
    @DynamoDBAttribute(attributeName = "primaryFundingMethod")
    public String getPrimaryFundingMethod() {
        return primaryFundingMethod;
    }
    public void setPrimaryFundingMethod(String primaryFundingMethod) {
        this.primaryFundingMethod = primaryFundingMethod;
    }

    @JsonProperty("bankCity")
    @DynamoDBAttribute(attributeName = "bankCity")
    public String getBankCity() {
        return bankCity;
    }
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    @JsonProperty("bankCountry")
    @DynamoDBAttribute(attributeName = "bankCountry")
    public String getBankCountry() {
        return bankCountry;
    }
    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    @JsonProperty("billingProfileName")
    @DynamoDBAttribute(attributeName = "billingProfileName")
    public String getBillingProfileName() {
        return billingProfileName;
    }
    public void setBillingProfileName(String billingProfileName) {
        this.billingProfileName = billingProfileName;
    }

    @JsonProperty("timeZone")
    @DynamoDBAttribute(attributeName = "timeZone")
    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("floatDays")
    @DynamoDBAttribute(attributeName = "floatDays")
    public long getFloatDays() {
        return floatDays;
    }
    public void setFloatDays(long floatDays) {
        this.floatDays = floatDays;
    }

    @JsonProperty("acquiringBank")
    @DynamoDBAttribute(attributeName = "acquiringBank")
    public String getAcquiringBank() {
        return acquiringBank;
    }
    public void setAcquiringBank(String acquiringBank) {
        this.acquiringBank = acquiringBank;
    }

    @DynamoDBAttribute(attributeName = "createDate")
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "MerchantOnBoardingRequest [requestId=" + requestId + ", merchantName=" + merchantName
                + ", organizationName=" + organizationName + ", street=" + street + ", city=" + city + ", state="
                + state + ", country=" + country + ", postalCode=" + postalCode + ", emailAddress=" + emailAddress
                + ", url=" + url + ", phoneNumber=" + phoneNumber + ", legalName=" + legalName + ", midRequestStatus="
                + midRequestStatus + ", midTransactionLimit=" + midTransactionLimit + ", purchaseCurrency="
                + purchaseCurrency + ", settlementCurrency=" + settlementCurrency + ", primaryFundingMethod="
                + primaryFundingMethod + ", bankCity=" + bankCity + ", bankCountry=" + bankCountry
                + ", billingProfileName=" + billingProfileName + ", timeZone=" + timeZone + ", floatDays=" + floatDays
                + ", acquiringBank=" + acquiringBank + ", createDate=" + createDate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (requestId ^ (requestId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MerchantOnBoardingRequest other = (MerchantOnBoardingRequest) obj;
        if (requestId != other.requestId)
            return false;
        return true;
    }

}
