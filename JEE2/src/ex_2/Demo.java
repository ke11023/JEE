package ex_2;
import java.io.*;
import java.util.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		CustomerDao dao = new CustomerDao();
		/*����һ���˿�*/
		Customer cus1=new Customer();
		cus1.setCusid(1010);
		cus1.setCusname("zhangsan");
		cus1.setCusphone("010-11111");
		dao.addCustomer(cus1);
		/*��ѯ���й˿�*/
		ArrayList<Customer> list=dao.allCustomers();
		for(int i=0;i<list.size();i++){
			 Customer cus=list.get(i);
			 System.out.println(cus.getCusid()+" "+
					 cus.getCusname()+" "+cus.getCusphone());
		}
		/*ͨ�����ɾ���˿�*/
		dao.deleteCustomerByID(1010);
	}

}
