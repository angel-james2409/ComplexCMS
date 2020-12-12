package com.hexaware.MLP211.factory;

import com.hexaware.MLP211.model.Vendor;
import java.util.List;

public interface VendorService {
    boolean addVendor(Vendor vendor)throws Throwable;
    boolean updateVendor(Vendor vendor)throws Throwable;
    boolean removeVendor(int id)throws Throwable;   
    Vendor findVendor (int id)throws Throwable;
    List<Vendor> getAllVendors()throws Throwable;
}

