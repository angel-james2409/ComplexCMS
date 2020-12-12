package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.WalletTransaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
//import com.hexaware.MLP211.model.Order;
import java.util.Date;

public class WalletTransactionPaymentRowMapper implements ResultSetMapper<WalletTransaction>{

	@Override
	public WalletTransaction map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
		WalletTransaction w=new WalletTransaction ();
		w.setTransactionId(rs.getInt(1));
		
		int cid=rs.getInt(2);
		w.getOrder().getCustomer().setId(cid);
		int vid=rs.getInt(3);
		w.getOrder().getVendor().setId(vid);

		Date trdate=rs.getDate(4);
		long ms=trdate.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ms);
		w.setTransactionDate(cal);

		int oid=rs.getInt(5);
		w.getOrder().setId(oid);

		w.setTransactionAmount(rs.getDouble(6));

		return w;
	}

}
