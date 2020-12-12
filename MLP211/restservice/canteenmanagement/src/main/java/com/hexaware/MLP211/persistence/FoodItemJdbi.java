package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Vendor;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

public interface FoodItemJdbi{

    @SqlUpdate("INSERT INTO FOOD_ITEMS (FOOD_NAME, DESCRIPTION, FOOD_PRICE, VENDOR_ID, PREPARATION_TIME) VALUES (:fi.name,:fi.description,:fi.price,:v.id,:fi.preparationTime)")
    @GetGeneratedKeys
    int insert(@BindBean("fi") FoodItem foodItem, @BindBean("v") Vendor vendor)throws Throwable;
    @SqlUpdate("delete from food_items where food_id=:fid")
    int delete (@Bind("fid") int id) throws Throwable;
    @SqlUpdate("update food_items set food_name= :fi.name, food_desc= :fi.desc, food_price= :fi.price, food_rating= fi.rating, preparation_time= :fi.preparationTime, vendor_id=v.id, foor_rating_count= fi.ratingCount where food_id= fi.id")
    int update(@BindBean("fi") FoodItem foodItem,@BindBean("v") Vendor vendor) throws Throwable;
    @SqlQuery("select * from food_items where food_id= :fid")
    @RegisterMapper(FoodItemRowMapper.class)
    FoodItem find(@Bind("fid") int id)throws Throwable;
    @SqlQuery("select * from FOOD_ITEMS")
    @RegisterMapper(FoodItemRowMapper.class)
    List<FoodItem> getAll() throws Throwable;
}