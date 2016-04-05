package ex_2;
import java.sql.*;
import java.util.*;

public class CustomerDao {
	public ArrayList<Customer> allCustomers() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		String sql = "select * from customers";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
				Customer cus = new Customer();
				cus.setCusid(rs.getInt(1));
				cus.setCusname(rs.getString(2));
				cus.setCusphone(rs.getString(3));
				list.add(cus);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	public void deleteCustomerByID(int id) {
			String sql = "delete from customers where cusid='"+id+"'";
			DBHelper. executeUpdate(sql);
	}

	public void addCustomer(Customer cus) {
		String sql = "insert into customers values("+cus.getCusid()+",'"+ cus.getCusname()+"','"+ cus.getCusphone()+"')";	
		DBHelper. executeUpdate(sql);			
	}


}
