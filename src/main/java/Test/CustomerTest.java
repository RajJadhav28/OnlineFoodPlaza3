package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Impl.CustomerDaoImpl;
import POJO.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		Customer c=new Customer();
		System.out.println("Enter the choice:");
		System.out.println("1.Add Customer.");
		System.out.println("2.Delete Customer.");
		System.out.println("3.Update Customer.");
		System.out.println("4.Search By Emailid.");
		System.out.println("5.Get all customer.");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:{
			System.out.println("Enter the name:");
			String custName=sc.nextLine();
			System.out.println("Enter the emailId:");
			String emailId=sc.nextLine();
			System.out.println("Enter the password:");
			String custPassword=sc.nextLine();
			System.out.println("Enter the contact no:");
			String contactNo=sc.nextLine();
			System.out.println("Enter the customer location:");
			String custLocation=sc.nextLine();
			Customer c1=new Customer(custName,emailId,custPassword,contactNo,custLocation);
			boolean b =cdao.addCustomer(c1);
			if(b) {
				System.out.println("Data inserted successfully.");
			}else {
				System.out.println("Data not inserted!!!");
			}
			break;
		}
		case 2:{
			System.out.println("Enter the emailId:");
			String emailId=sc.nextLine();
			
			boolean b=cdao.deleteCustomer(emailId);
			if(b) {
				System.out.println("Data deleted successfully");
			}else {
				System.out.println("Data not deleted.");
			}
			break;
		}
		case 3:{
			System.out.println("Enter the emailId:");
			String emailId=sc.nextLine();
			System.out.println("Enter the name:");
			String custName=sc.nextLine();
			System.out.println("Enter the password:");
			String custPassword=sc.nextLine();
			System.out.println("Enter the contact no.:");
			String contactNo=sc.nextLine();
			System.out.println("Enter the custLocation:");
			String custLocation=sc.nextLine();
			c.setEmailId(emailId);
			c.setCustName(custName);
			c.setCustPassword(custPassword);
			c.setContactNo(contactNo);
			c.setCustLocation(custLocation);
			
			boolean b=cdao.updateCustomer(c);
			if(b) {
				System.out.println("data updated successfully");
			}else {
				System.out.println("Not updated!!!");
		}
			break;
		}
		case 4:{
			System.out.println("Enter the emailId:");
			String emailId=sc.nextLine();
			List<Customer>li=cdao.searchByEmail(emailId);
			if(li!=null) {
				Iterator<Customer> it=li.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}else {
				System.out.println("Data not found!!!");
			}
			break;	
		}
		case 5:{
			List<Customer>li=cdao.getAllCustomer();
			Iterator<Customer>it=li.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
		}

	}

}
