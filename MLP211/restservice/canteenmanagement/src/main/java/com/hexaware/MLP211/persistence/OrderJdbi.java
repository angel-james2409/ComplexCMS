package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.Order;
import java.util.List;
import java.util.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


public interface OrderJdbi{

    @SqlUpdate("insert into ORDERS(ORDERS_DATE,ORDERS_STATUS,ORDERS_AMOUNT,CUSTOMER_ID,VENDOR_ID,ORDERS_ESTIMATED_TIME)VALUES(:odate,:osts,:o.amount,:cid,:vid,:oesttime)")
    @GetGeneratedKeys
    int insert(@BindBean("o")Order order,@Bind("vid")int vid,@Bind("cid")int cid, @Bind("odate") Date date,@Bind("oesttime") Date estimatedTime,@Bind("osts") String status )throws Throwable;
    @SqlUpdate("delete from ORDERS where ORDERS_ID=:oid)")
    int delete (@Bind("oid")int id) throws Throwable;
    @SqlUpdate("update ORDERS set(ORDERS_DATE=:odate,ORDERS_STATUS=:osts,ORDERS_AMOUNT=:o.amount,CUSTOMER_ID=:cid,VENDOR_ID=:vid,ORDERS_ESTIMATED_TIME=:oesttime where ORDERS_ID=:o.id)")
    int update1(@BindBean("o")Order order,@Bind("vid")int vid,@Bind("cid")int cid, @Bind("odate") Date date,@Bind("oesttime") Date estimatedTime,@Bind("osts") String status) throws Throwable;
    @SqlUpdate("update ORDERS set(ORDERS_DATE=:odate,ORDERS_STATUS=:osts,ORDERS_AMOUNT=:o.amount,CUSTOMER_ID=:cid,VENDOR_ID=:vid,ORDERS_ESTIMATED_TIME=:oesttime,ORDERS_DELIVERY_TIME=:odeltime where ORDERS_ID=:o.id)")
    int update2(@BindBean("o")Order order,@Bind("vid")int vid,@Bind("cid")int cid, @Bind("odate") Date date,@Bind("oesttime") Date estimatedTime,@Bind("odeltime") Date deliveryTime,@Bind("osts") String status) throws Throwable;
    @SqlQuery("select*from ORDERS where ORDERS_ID=:oid")
    @RegisterMapper(OrderRowMapper.class)
    Order find(@Bind("oid") int id)throws Throwable;
    @SqlQuery("select * from ORDERS")
    @RegisterMapper(OrderRowMapper.class)
    List<Order> getAll() throws Throwable;
}
    