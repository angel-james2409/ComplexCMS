package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Customer;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Date;

public interface CustomerJdbi{

    @SqlUpdate("insert into Customer(CUSTOMER_NAME,CUSTOMER_DOB,CUSTOMER_PHONE1,CUSTOMER_PHONE2,CUSTOMER_EMAIL,customer_wallet_amt) VALUES(:c.name,:custdob,:ph1, :ph2,:em, 0)")
    @GetGeneratedKeys
    int insert(@BindBean("c") Customer customer,@Bind("custdob") Date date, @Bind("em") String em, @Bind("ph1") String ph1, @Bind("ph2")String ph2)throws Throwable;
    @SqlUpdate("update Customer SET CUSTOMER_NAME=:c.name,CUSTOMER_DOB=:custdob ,CUSTOMER_PHONE1=:ph1,CUSTOMER_PHONE2=:ph2,customer_email= :em, customer_wallet_amt=0 where customer_id= :c.id")
    int update (@BindBean("c")Customer customer, @Bind("custdob") Date date, @Bind("em") String em, @Bind("ph1") String ph1, @Bind("ph2")String ph2) throws Throwable;
    @SqlUpdate("delete from Customer where customer_id=:cid")
    int delete(@Bind("cid") int id) throws Throwable;
    @SqlQuery("select * from Customer where customer_id=:cid")
    @RegisterMapper(CustomerRowMapper.class)
    Customer find(@Bind("cid")int id)throws Throwable;
    @SqlQuery("select * from Customer")
    @RegisterMapper(CustomerRowMapper.class)
    List<Customer> getAll() throws Throwable;
}