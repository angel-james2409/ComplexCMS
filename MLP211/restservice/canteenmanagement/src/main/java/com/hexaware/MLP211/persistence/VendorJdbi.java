package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.Vendor;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;

public interface VendorJdbi {
     @SqlUpdate("insert into Vendor (VENDOR_NAME,VENDOR_PHONE1,VENDOR_PHONE2,VENDOR_ADDRESS,VENDOR_CONTACTPERSON, VENDOR_EMAIL) VALUES(:v.name,:ph1,:ph2,:v.address, :v.contactPersonName, :em)")
     @GetGeneratedKeys
     int insert(@BindBean("v") Vendor vendor, @Bind("ph1") String phoneOne, @Bind("ph2")String phoneTwo, @Bind("em") String email)throws Throwable;

     @SqlUpdate("update Vendor SET VENDOR_NAME=:v.name,VENDOR_PHONE1=:ph1,VENDOR_PHONE2=:ph2,VENDOR_ADDRESS=:v.address, VENDOR_CONTACTPERSON=:v.contactPersonName, VENDOR_EMAIL= :em, VENDOR_RATING= :v.rating, VENDOR_RATING_COUNT=v.ratingCount where vendor_id=:v.id")
     int update(@BindBean("v")Vendor vendor, @Bind("ph1") String phoneOne, @Bind("ph2")String phoneTwo, @Bind("em") String email)throws Throwable;

     @SqlUpdate("delete from Vendor where vendor_id=:vid")
     int  delete(@Bind("vid")int id)throws Throwable; 

     @SqlQuery("select * from Vendor where vendor_id=:vid")
     @RegisterMapper(VendorRowMapper.class)  
     Vendor find (@Bind("vid")int id)throws Throwable;
     
     @SqlQuery("select * from Vendor")
     @RegisterMapper(VendorRowMapper.class)  
     List<Vendor> getAll()throws Throwable;
}

