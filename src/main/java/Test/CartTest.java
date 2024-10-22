package Test;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import Impl.CartDaoImpl;
import Impl.FoodDaoImpl;
import Impl.LoginDaoImpl;
import POJO.Cart;
import POJO.Food;

public class CartTest {

	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		boolean exit=false,flag;
		
		
		FoodDaoImpl fimpl=new FoodDaoImpl();
		List<Food> flist=null;
		CartDaoImpl cimpl=new CartDaoImpl();
		List<Cart> clist=null;
		
		Cart cart=null;
		
		int cartid;
		int foodid;
		//String cEmail = null;
		int fquantity;
		String fname;
		
		System.out.println("Enter email id:");
		String email=sc.nextLine();
		System.out.println("Enter password:");
		String password=sc.nextLine();
		
		boolean login=new LoginDaoImpl().userLogin(email, password);
		if(login==true) {
			do {
				System.out.println("1--->Add to cart");
				System.out.println("2--->Show myCart");
				System.out.println("3--->update quantity of item");
				System.out.println("4--->Delete item from cart");
				System.out.println("5--->Clear my cart");
				int option =sc.nextInt();
				sc.nextLine();
				
				
				switch(option) 
				{
				case 1:flist=fimpl.getAllFood();
				for(Food f:flist) {
					System.out.println(f);
					System.out.println("-----------------------------------");
				}
				System.out.println("Enter id of food you want to add to cart");
				foodid=sc.nextInt();
				System.out.println("Enter quantity of this food");
				fquantity=sc.nextInt();
				
				cart=new Cart();
				cart.setFoodid(foodid);
				cart.setFquantity(fquantity);
				cart.setcEmail(email);
				flag=cimpl.addToCart(cart);
				if(flag) 
				{
					System.out.println("Food added successfully to cart");
				}
				
				else 
				{
					System.out.println("Error while adding this item in cart.Please try again");
				}
				break;
				case 2:
					clist=cimpl.searchCartByEmailId(email);
					if(clist==null||clist.isEmpty()) {
						System.out.println("Your cart is empty.Please add items to your cart first.");
					}else {
						double bill=0;
						for(Cart c1:clist) {
							bill=bill+c1.getTotalPrice();
							System.out.println(c1);
							System.out.println("---------------------------------------------------");
							
						}
						System.out.println("Amount payable:"+bill);
					}
					break;
				case 3:
					System.out.println("Enter the cart is for the item whose quantity is to be changed...");
					cartid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the quantity for add item");
					fquantity=sc.nextInt();
					sc.nextLine();
					flag=cimpl.updateCart(cartid, fquantity);
					if(flag) {
						System.out.println("Quantity of your food item has been changed");
					}
					else {
						System.out.println("Error while changing quantity!!!");
					}
					break;
				
				}
			}while(exit==false);

	}//if closing
		

	}

}
