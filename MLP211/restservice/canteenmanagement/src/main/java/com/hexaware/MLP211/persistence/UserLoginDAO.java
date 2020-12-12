package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.UserLogin;
import java.util.List;

public interface UserLoginDAO {
    boolean insertUserLogin(UserLogin userLogin)throws Throwable;
    boolean updateUserLogin(UserLogin userLogin)throws Throwable;
    boolean deleteUserLogin(String username) throws Throwable;
    UserLogin findUserLogin(String username)throws Throwable;
    List<UserLogin> getAllUserLogins()throws Throwable;
}



