package com.cts.ms.dao;

import java.util.List;

import com.cts.ms.exception.MSException;
import com.cts.ms.model.Merchants;

public interface MSMerchantManagementDAO {

    public void save(Merchants merchants) throws MSException;

    public Merchants getProvisionedMerchant(final String mid) throws MSException;

    public List<Merchants> listAllProvisionedMerchants() throws MSException;

    public Boolean deleteMerchant(final String mid) throws MSException;
}
