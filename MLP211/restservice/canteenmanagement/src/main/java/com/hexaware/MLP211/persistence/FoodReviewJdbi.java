package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.FoodReview;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


public interface FoodReviewJdbi{

    @SqlUpdate("------")
    int insert(FoodReview foodReview)throws Throwable;
    @SqlUpdate("----------")
    int delete (int id) throws Throwable;
    @SqlUpdate("-----------")
    int update(FoodReview foodReview) throws Throwable;
    @SqlQuery("---------")
    @RegisterMapper(FoodReviewRowMapper.class)
    FoodReview find(int id)throws Throwable;
    @SqlQuery("---------")
    @RegisterMapper(FoodReviewRowMapper.class)
    List<FoodReview> getAll() throws Throwable;
}