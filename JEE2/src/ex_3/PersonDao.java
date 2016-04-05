package ex_3;
import java.sql.*;
import java.util.*;

public class PersonDao {
	public ArrayList<Person> allPerson() {
		ArrayList<Person> list = new ArrayList<Person>();
		String sql = "select * from Person";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Person per = new Person();
				per.setPid(rs.getInt(1));
				per.setName(rs.getString(2));
				per.setSex(rs.getString(3));
				per.setTel(rs.getString(4));
				per.setAddress(rs.getString(5));
				per.setEmail(rs.getString(6));
				list.add(per);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	
	public void deletePersonByID(int id) {
			String sql = "delete from Person where pid='"+id+"'";
			DBHelper. executeUpdate(sql);
	}

	public void addPerson(Person per) {
		String sql = "insert into Person values("+per.getPid()+",'"+ per.getName()+"','"+ per.getSex()+
				"','"+ per.getTel()+"','"+ per.getAddress()+"','"+ per.getEmail()+"')";	
		DBHelper. executeUpdate(sql);			
	}
	
	public void editPerson(Person per){
		this.deletePersonByID(per.getPid());
		this.addPerson(per);
	}

	public ArrayList<Person> queryPersonByName(String name){
		ArrayList<Person> list = new ArrayList<Person>();
		String sql = "select * from Person where name='"+name+"'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Person per = new Person();
				per.setPid(rs.getInt(1));
				per.setName(rs.getString(2));
				per.setSex(rs.getString(3));
				per.setTel(rs.getString(4));
				per.setAddress(rs.getString(5));
				per.setEmail(rs.getString(6));
				list.add(per);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
}
