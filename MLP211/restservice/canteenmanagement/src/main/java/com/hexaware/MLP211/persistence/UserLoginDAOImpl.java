package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.persistence.UserLoginDAO;
import java.util.List;
import java.util.*;
import com.hexaware.MLP211.model.UserInfo;

import org.skife.jdbi.v2.DBI;

public class UserLoginDAOImpl implements UserLoginDAO{
    @Override
    public boolean insertUserLogin(UserLogin userLogin)throws Throwable{
        boolean result= false;
        try{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		UserLoginJdbi jdbi = dbi.open(UserLoginJdbi.class);
		int rc=jdbi.insert(userLogin.getUserName(),userLogin.getPassword(),userLogin.getUserType().toString(),userLogin.getCustomerVendorId(),userLogin.getLastPasswordUpdate().getTime());
        
         result=true;
        return result;
    }
        catch(Throwable e ){
            e.printStackTrace();
			return false;
		}
    }
    @Override
    public boolean updateUserLogin(UserLogin userLogin)throws Throwable{
        try{		
            DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
            UserLoginJdbi jdbi = dbi.open(UserLoginJdbi.class);
            int rc=jdbi.update(userLogin,userLogin.getLastPasswordUpdate().getTime(), userLogin.getUserName());
           // customer.vendor.setId(rc);
            return true;   
           }catch(Throwable e ){
           e.printStackTrace();
           return false;
                   }
    }
    @Override   
    public boolean deleteUserLogin(String username)throws Throwable{
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		UserLoginJdbi jdbi = dbi.open(UserLoginJdbi.class);
		int  rc=jdbi.delete(username);
		 result=true;
		return result;
    }
    @Override
    public UserLogin findUserLogin(String username)throws Throwable{
        UserLogin ul=null;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		UserLoginJdbi jdbi = dbi.open(UserLoginJdbi.class);
		 UserLogin rc=jdbi.find(username);
		return rc;
    }   
    @Override
    public List<UserLogin> getAllUserLogins() throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		UserLoginJdbi jdbi = dbi.open(UserLoginJdbi.class);
		return jdbi.getAll();
    }
}



