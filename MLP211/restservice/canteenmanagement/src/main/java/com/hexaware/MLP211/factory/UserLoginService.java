package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.UserLogin;
import java.util.List;

public interface UserLoginService {
    boolean addUserLogin(UserLogin userLogin)throws Throwable;
    boolean updateUserLogin(UserLogin userLogin)throws Throwable;
    boolean removeUserLogin(String username) throws Throwable;
    UserLogin findUserLogin(String username)throws Throwable;
    List<UserLogin> getAllUserLogins()throws Throwable;
}

