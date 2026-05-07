package JDBC;

import java.sql.*;
import java.util.Scanner;

public class OrderService {

    public static void placeOrder(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {

            double total = 0;

            String orderSQL = "INSERT INTO orders(total_amount) VALUES (0)";
            PreparedStatement psOrder = con.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS);
            psOrder.executeUpdate();

            ResultSet rs = psOrder.getGeneratedKeys();
            rs.next();
            int order_Id = rs.getInt(1);

            while (true) {
                System.out.print("Enter Item ID (0 to finish): ");
                int item_Id = sc.nextInt();

                if (item_Id == 0) break;

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                
                PreparedStatement psPrice = con.prepareStatement("SELECT price FROM menu WHERE id=?");
                psPrice.setInt(1, item_Id);
                ResultSet rsPrice = psPrice.executeQuery();

                if (rsPrice.next()) {
                    double price = rsPrice.getDouble("price");
                    total += price * qty;

                    
                    PreparedStatement psItem = con.prepareStatement(
                            "INSERT INTO order_items(order_id, item_id, quantity) VALUES (?, ?, ?)");
                    psItem.setInt(1, order_Id);
                    psItem.setInt(2, item_Id);
                    psItem.setInt(3, qty);
                    psItem.executeUpdate();

                } else {
                    System.out.println("Invalid Item ID");
                }
            }

            
            PreparedStatement psUpdate = con.prepareStatement(
                    "UPDATE orders SET total_amount=? WHERE order_id=?");
            
            psUpdate.setDouble(1, total);
            psUpdate.setInt(2, order_Id);
            psUpdate.executeUpdate();

            System.out.println("Order placed. Total = ₹" + total);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}