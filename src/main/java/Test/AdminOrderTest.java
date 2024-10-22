package Test;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Impl.CartDaoImpl;
import Impl.OrderDaoImpl;
import POJO.OrderFood;

public class AdminOrderTest {

	public static void main(String[] args) {
		boolean exit=false;
		Scanner sc=new Scanner(System.in);
		CartDaoImpl cimpl=new CartDaoImpl();
		OrderDaoImpl oimpl=new OrderDaoImpl();
		OrderFood o=null;
		List<OrderFood>olist=null;
		int orderId;
		String orderDate;
		double totalBill;
		String emailId;
		String orderStatus;
        
		do
		{
			System.out.println("1---->Show all orders");
			System.out.println("2---->Show order by id");
			System.out.println("3---->Change order status");
			int option=sc.nextInt();
			sc.nextLine();
			switch(option)
			{
			case 1:
			      olist=oimpl.showAllOrder();
			      if(olist!=null && olist.isEmpty()!=true)
			      {
			    	  for(OrderFood ol : olist)
			    	  {
			    		  System.out.println("Ordered by : " + ol.getEmailId());
			    		  System.out.println("Order no : " + ol.getOrderId());
			    		  System.out.println("Order date : " + ol.getOrderDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			    		  System.out.println("Bill : " + ol.getTotalBill());
			    		  System.out.println("Status : " + ol.getOrderStatus());
			    		  System.out.println("_______________________________");  		  
			    	  }
			      }
			      else
			    	  System.out.println("No one has ordered anything yet !!!");
			      break;
			case 2:
				System.out.println("Enter the Id to find data:");
				 orderId=sc.nextInt();
				 OrderFood f3=oimpl.showOrderById(orderId);
				 if(f3!=null) {
					 System.out.println(f3);
				 }else {
					 System.out.println("Data not found!!!");
				 }
				 break;
			 case 3:
				 System.out.println("Enter the orderId to change order status:");
				  orderId=sc.nextInt();
				 System.out.println("Enter the status:");
				 orderStatus=sc.next();sc.nextLine();
				 
				 boolean b=oimpl.changeOrderStatus(orderStatus, orderId);
				 if(b) {
					 System.out.println("Order updated successfully");
				 }else {
					 System.out.println("Not updated");
				 }
				
			}
		}while(exit==false);

	}

}
