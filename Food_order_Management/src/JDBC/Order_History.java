package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Order_History {
	
	public static void vieworders() {
		
		try(Connection con=DBConnection.getConnection()){
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("Select * from orders");
			
			System.out.println("order_id\t  total_amount\t  order_date");
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("order_id")+"\t" +
						           rs.getDouble("total_amount")+"\t"+
				                    rs.getTimestamp("order_date"));
			}
			
			}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}

}

