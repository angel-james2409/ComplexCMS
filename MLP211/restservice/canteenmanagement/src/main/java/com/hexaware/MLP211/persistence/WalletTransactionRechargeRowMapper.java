package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.WalletTransaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.util.Date;
import java.util.Calendar;

public class WalletTransactionRechargeRowMapper implements ResultSetMapper<WalletTransaction>{

	@Override
	public WalletTransaction map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
		WalletTransaction wt=new WalletTransaction ();

		Date trdate=rs.getDate(2);
		long ms=trdate.getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ms);
		wt.setTransactionDate(cal);

		wt.setTransactionAmount(rs.getDouble(3));

		int cid=rs.getInt(4);
		wt.getOrder().getCustomer().setId(cid);


		return wt;
	}

}
