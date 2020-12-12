package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.FoodReview;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


public class FoodReviewRowMapper implements ResultSetMapper<FoodReview>{

	@Override
	public FoodReview map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
	FoodReview fr=new FoodReview();


	return fr;
	}

}
