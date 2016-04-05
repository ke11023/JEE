package ex_2;
import java.io.*;
import java.util.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		CustomerDao dao = new CustomerDao();
		/*增加一个顾客*/
		Customer cus1=new Customer();
		cus1.setCusid(1010);
		cus1.setCusname("zhangsan");
		cus1.setCusphone("010-11111");
		dao.addCustomer(cus1);
		/*查询所有顾客*/
		ArrayList<Customer> list=dao.allCustomers();
		for(int i=0;i<list.size();i++){
			 Customer cus=list.get(i);
			 System.out.println(cus.getCusid()+" "+
					 cus.getCusname()+" "+cus.getCusphone());
		}
		/*通过编号删除顾客*/
		dao.deleteCustomerByID(1010);
	}

}
