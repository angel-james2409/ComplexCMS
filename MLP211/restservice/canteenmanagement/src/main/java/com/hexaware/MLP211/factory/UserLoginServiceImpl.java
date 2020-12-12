package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.persistence.UserLoginDAOImpl;
import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.factory.UserLoginService;
import java.util.List;

public class UserLoginServiceImpl implements UserLoginService{
    @Override
    public boolean addUserLogin(UserLogin userLogin)throws Throwable{

        return new UserLoginDAOImpl().insertUserLogin(userLogin) ;
    }
    @Override
    public boolean updateUserLogin(UserLogin userLogin)throws Throwable{
        return new UserLoginDAOImpl().updateUserLogin(userLogin);
    }
    @Override   
    public boolean removeUserLogin(String username)throws Throwable{
        return new UserLoginDAOImpl().deleteUserLogin(username);
    }
    @Override
    public UserLogin findUserLogin(String username)throws Throwable{
        return new UserLoginDAOImpl().findUserLogin(username);
    }   
    @Override
    public List<UserLogin> getAllUserLogins() throws Throwable{
        return new UserLoginDAOImpl().getAllUserLogins();
    }
}


