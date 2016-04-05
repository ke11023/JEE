package ex_1;

import java.sql.*;

public class Demo {
	private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=JEE";
	private static String userName="gj";
 	private static String userPwd="123";
 	public static void main(String[] args){
 		try{
 			Class.forName(driverName);
 			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
 			Statement cmd = dbConn.createStatement();
			String sql = "select * from customers ";
			ResultSet rs = cmd.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
 			dbConn.close();
 		}catch(Exception e){
 			e.printStackTrace();
 			
 		}    
 	}
}
