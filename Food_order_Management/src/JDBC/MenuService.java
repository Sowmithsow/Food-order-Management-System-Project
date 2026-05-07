package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MenuService {
	
	public static void menuservice() {
		
		try(Connection con=DBConnection.getConnection()){
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("Select * from Menu");
			
			System.out.println("Id\t  itemname \t  price");
			
			while(rs.next()) {
				
				
				System.out.println(rs.getInt("id")+  "\t"+
						           rs.getString("item_name")+  "\t"+
						           rs.getDouble("price"));
				
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


