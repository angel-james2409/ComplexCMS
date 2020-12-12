package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.hexaware.MLP211.model.OrderStatus;

public class OrderRowMapper implements ResultSetMapper<Order>{

	@Override
	public Order map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
		Order o=new Order ();
	o.setId(rs.getInt(1));

	java.sql.Date sd=rs.getDate(2);
	if(sd != null){
	long ms=sd.getTime();
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(ms);
	o.setOrderDate(calendar);
	}
	String st = rs.getString(8);
	if(st.equals("ACCEPTED"))
			o.setOrderStatus(OrderStatus.ACCEPTED);
	if(st.equals("CANCELLED"))
			o.setOrderStatus(OrderStatus.CANCELLED);
	if(st.equals("DELIVERED"))
			o.setOrderStatus(OrderStatus.DELIVERED);
	if(st.equals("PENDING"))
			o.setOrderStatus(OrderStatus.PENDING);


	o.getCustomer().setId(rs.getInt(3));
	o.getVendor().setId(rs.getInt(4));

	
	java.sql.Date sd1=rs.getDate(5);
	if(sd1 != null){
	long ms1=sd1.getTime();
	Calendar calendar1 = Calendar.getInstance();
	calendar1.setTimeInMillis(ms1);
	o.setEstimatedDeliveryTime(calendar1);
	}

	
	java.sql.Date sd2=rs.getDate(6);
	if(sd2 != null){
	long ms2=sd2.getTime();
	Calendar calendar2 = Calendar.getInstance();
	calendar2.setTimeInMillis(ms2);
	o.setActualDeliveryTime(calendar2);
	o.setAmount(rs.getDouble(7));
	}
		return o;
	}

}
