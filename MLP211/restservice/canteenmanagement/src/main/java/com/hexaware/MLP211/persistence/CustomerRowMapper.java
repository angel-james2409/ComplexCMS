package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CustomerRowMapper implements ResultSetMapper<Customer>{

	@Override
	public Customer map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
	Customer c=new Customer();
     c.setId(rs.getInt(1));
	 c.setName(rs.getString(2));
	 
	 java.sql.Date sd=rs.getDate(4);
	 long ms=sd.getTime();

	 Calendar calendar=Calendar.getInstance();
	 calendar.setTimeInMillis(ms);

	 c.setDateOfBirth(calendar);

	 c.getContactInfo().setPhoneOne(rs.getString(5));
	 c.getContactInfo().setPhoneTwo(rs.getString(6));
	 c.getContactInfo().setEmail(rs.getString(7));


	
	return c;
	}

}
