package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.OrderItem;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Order;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;

public interface OrderItemJdbi {
    @SqlUpdate("insert into ORDER_ITEMS(ORDERs_ID,SERIAL_NO,FOOD_ID,QUANTITY,PRICE,DISCOUNT) VALUES (:o.id, :ord_it_slno,:f.id,:oi.quantity,:f.price, :oi.discount)")
    @GetGeneratedKeys
    int insert(@BindBean("oi")OrderItem orderItem, @BindBean("o") Order order,@BindBean("f") FoodItem f, @Bind("ord_it_slno") int slno)throws Throwable;

    @SqlUpdate("update ORDER_ITEMS set FOOD_ID=:oi.foodItem.id,QUANTITY=:oi.quantity,PRICE=:oi.foodItem.price,DISCOUNT=:oi:discount where orderId=:oi.order.id and slno=:ord_it_slno ")
    int update(@BindBean ("oi")OrderItem orderItem, @BindBean("o") Order order,  @BindBean("ord_it_slno")int slno)throws Throwable;

    @SqlUpdate("delete  from ORDER_ITEM")
    int  delete(int orderId, int slno)throws Throwable;

    @SqlQuery("select * from ORDER_ITEM where orderId=? and slno=?")
    @RegisterMapper (OrderItemRowMapper.class) 
    OrderItem find (int orderId, int slno)throws Throwable;

    @SqlQuery("select * from ORDER_ITEM where orderId = ?")
    @RegisterMapper (OrderItemRowMapper.class) 
    List<OrderItem> getAll(int orderId)throws Throwable;
}
