package com.hexaware.MLP211.factory;

import com.hexaware.MLP211.persistence.VendorDAOImpl;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.factory.VendorService;

import java.util.List;
public class VendorServiceImpl implements VendorService{
    @Override
    public boolean addVendor(Vendor vendor)throws Throwable{
        return new VendorDAOImpl().insertVendor(vendor);
    }
    @Override
    public boolean updateVendor(Vendor vendor)throws Throwable{
        return new VendorDAOImpl().updateVendor(vendor);
    }
    @Override
    public boolean removeVendor(int id)throws Throwable{
        return new VendorDAOImpl().deleteVendor(id);
    }
    @Override
    public Vendor findVendor(int id)throws Throwable{
        return new VendorDAOImpl().findVendor(id);
    }
    @Override   
    public List<Vendor> getAllVendors() throws Throwable{
        return new VendorDAOImpl().getAllVendors();
    }
}
