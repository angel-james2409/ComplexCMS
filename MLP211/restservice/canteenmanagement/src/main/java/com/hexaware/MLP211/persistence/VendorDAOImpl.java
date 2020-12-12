package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Vendor;

import org.skife.jdbi.v2.DBI;

import com.hexaware.MLP211.persistence.VendorDAO;

import java.util.List;
public class VendorDAOImpl implements VendorDAO{
    @Override
    public boolean insertVendor(Vendor vendor)throws Throwable{
        try{
        DBI dbi=new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false","root","Password123");
        VendorJdbi jdbi=dbi.open(VendorJdbi.class);
        int generatedValue=jdbi.insert(vendor, vendor.getContactInfo().getPhoneOne(),vendor.getContactInfo().getPhoneTwo(),vendor.getContactInfo().getEmail());
        vendor.setId(generatedValue);
        return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean updateVendor(Vendor vendor)throws Throwable{
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		VendorJdbi jdbi = dbi.open(VendorJdbi.class);
		int rc=jdbi.update(vendor,vendor.getContactInfo().getPhoneOne(),vendor.getContactInfo().getPhoneTwo(),vendor.getContactInfo().getEmail());
		if(rc>0) result=true;
		return result;
    }
    @Override
    public boolean deleteVendor(int id)throws Throwable{
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		VendorJdbi jdbi = dbi.open(VendorJdbi.class);
		int rc=jdbi.delete(id);
		if(rc>0) result=true;
		return result;
    }
    @Override
    public Vendor findVendor(int id)throws Throwable{
        Vendor v=null;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		VendorJdbi jdbi = dbi.open(VendorJdbi.class);
		v=jdbi.find(id);
		return v;
    }
    @Override   
    public List<Vendor> getAllVendors() throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		VendorJdbi jdbi = dbi.open(VendorJdbi.class);
		return jdbi.getAll();
    }
}
