package com.cts.ms.service;

import java.util.List;

import com.cts.ms.dao.MSMerchantManagementDAO;
import com.cts.ms.dao.MerchantManagementDAO;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.Merchants;

public class MerchantManagementService implements MSMerchantManagementService {

    private MSMerchantManagementDAO msMerchantManagementDAO;

    public MerchantManagementService() {
        super();
        this.msMerchantManagementDAO = new MerchantManagementDAO();
    }

    @Override
    public Merchants getProvisionedMerchant(String mid) throws MSException {
        return msMerchantManagementDAO.getProvisionedMerchant(mid);
    }

    @Override
    public List<Merchants> listAllProvisionedMerchants() throws MSException {
        return msMerchantManagementDAO.listAllProvisionedMerchants();
    }

    @Override
    public Boolean deleteMerchant(String mid) throws MSException {
        return msMerchantManagementDAO.deleteMerchant(mid);
    }

}
