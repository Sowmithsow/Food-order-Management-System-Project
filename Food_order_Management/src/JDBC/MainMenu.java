package JDBC;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {
		
		System.out.println("Welcome to our Food order System"); 
		
		System.out.println("Press 1:For view Menu"); 
		
		System.out.println("Press 2: To Place order");
		
		System.out.println("Press 3:To view Order");
		
		System.out.println("Press 4:To Exit");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:MenuService.menuservice(); break;
			
		case 2:OrderService.placeOrder(sc); break;
			
		case 3:Order_History.vieworders(); break;
			
		case 4:System.out.println("Exit Successful! Byee!"); break;
		
		default:System.out.println("Invalid choice!");
		}

	}

}
}
