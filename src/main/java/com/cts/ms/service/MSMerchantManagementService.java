package com.cts.ms.service;

import java.util.List;

import com.cts.ms.exception.MSException;
import com.cts.ms.model.Merchants;

public interface MSMerchantManagementService {

    public Merchants getProvisionedMerchant(final String mid) throws MSException;

    public List<Merchants> listAllProvisionedMerchants() throws MSException;

    public Boolean deleteMerchant(final String mid) throws MSException;
}
