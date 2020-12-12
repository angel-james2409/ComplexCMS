package com.hexaware.MLP211.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hexaware.MLP211.model.OrderItem;

public class OrderItemRowMapper implements ResultSetMapper<OrderItem>{

	@Override
	public OrderItem  map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
    OrderItem oi=new OrderItem();
        oi.getFoodItem().setId(rs.getInt(2));
		oi.setQuantity(rs.getInt(3));
		oi.setPrice(rs.getDouble(4));
		oi.setDiscount(rs.getDouble(5));
		oi.getOrder().setId(rs.getInt(6));

     return oi;
	}

}
