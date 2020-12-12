package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class VendorRowMapper implements ResultSetMapper<Vendor>{

	@Override
	public Vendor map(int arg0, ResultSet rs, StatementContext arg2) throws SQLException {
		Vendor v=new Vendor();
		v.setId(rs.getInt(1));
		v.setName(rs.getString(2));
		v.getContactInfo().setPhoneOne(rs.getString(3));
		v.getContactInfo().setPhoneTwo(rs.getString(4));
		v.setAddress(rs.getString(5));
		v.setContactPersonName(rs.getString(6));
		v.getContactInfo().setEmail(rs.getString(7));
		v.setRating(rs.getInt(8));
		v.setRatingCount(rs.getInt(9));
	
		return v;
	}

}
