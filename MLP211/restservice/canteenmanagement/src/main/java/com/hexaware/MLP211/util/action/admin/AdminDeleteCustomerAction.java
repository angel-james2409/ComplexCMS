package com.hexaware.MLP211.util.action.admin;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import java.util.List;

public class AdminDeleteCustomerAction extends Action{

    @Override
    public void begin(){
       // System.out.println("Implemented by Raji");
        System.out.println("\t\t Delete Customer");
        System.out.println("\t--------------------------------------");
    }

    @Override
    public void execute(){
        //interact with service layer
        //System.out.println("executing");

        try{
		List<Customer> list = new CustomerServiceImpl().getAllCustomers();
            int id=0;
            id=new InputUtil().readCustomerIdInput("Enter id to Delete the Customer",list);
            boolean res2= new UserLoginServiceImpl().removeUserLogin((new CustomerServiceImpl().findCustomer(id)).getName());
            boolean res=new CustomerServiceImpl().removeCustomer(id);
            System.out.println(res+", "+res2);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @Override
    public void end(){
        System.out.println("--------------------------");
    }

}