package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Vendor;
import java.util.List;

public interface VendorDAO {
    boolean insertVendor(Vendor vendor)throws Throwable;
    boolean updateVendor(Vendor vendor)throws Throwable;
    boolean deleteVendor(int id)throws Throwable;   
    Vendor findVendor (int id)throws Throwable;
    List<Vendor> getAllVendors()throws Throwable;
}

