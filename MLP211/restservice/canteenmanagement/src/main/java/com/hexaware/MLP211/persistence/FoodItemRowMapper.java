package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class FoodItemRowMapper implements ResultSetMapper<FoodItem>{

	@Override
	public FoodItem map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
		FoodItem fi=new FoodItem();
		fi.setId(rs.getInt(1));
		fi.setName(rs.getString(2));
		fi.setPrice(rs.getDouble(3));

		int vid= rs.getInt(4);
		Vendor v= new Vendor();
		v.setId(vid);
		fi.setVendor(v);

		fi.setRating(rs.getInt(5));

		fi.setPreparationTime(rs.getInt(6));
		fi.setDescription(rs.getString(7));
		fi.setRatingCount(rs.getInt(8));

		return fi;
	}

}
