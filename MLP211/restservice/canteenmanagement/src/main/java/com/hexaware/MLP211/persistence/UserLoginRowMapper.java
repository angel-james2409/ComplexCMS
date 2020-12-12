package com.hexaware.MLP211.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.model.UserType;

import java.util.Date;
import java.util.Calendar;

public class UserLoginRowMapper implements ResultSetMapper<UserLogin>{

	@Override
	public UserLogin map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
    UserLogin ul=new UserLogin();
    ul.setUserName(rs.getString(2));
	ul.setPassword(rs.getString(3));
	String str= rs.getString(4);
	if(str.equals("ADMIN"))
		ul.setUserType(UserType.ADMIN);
	if(str.equals("CUSTOMER"))
		ul.setUserType(UserType.CUSTOMER);
	if(str.equals("VENDOR"))
		ul.setUserType(UserType.VENDOR);

	ul.setCustomerVendorId(rs.getInt(5));	

		Date sd1=rs.getDate(6);
		long ms1=sd1.getTime();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTimeInMillis(ms1);
ul.setLastPasswordUpdate(calendar1);

     return ul;
	}

}


