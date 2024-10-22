package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Impl.FoodDaoImpl;
import POJO.Food;

public class FoodTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		FoodDaoImpl fdao=new FoodDaoImpl();
		Food f=new Food();
		System.out.println("Enter the choice:");
		System.out.println("1.Add Food:");
		System.out.println("2.Delete Food:");
		System.out.println("3.Update Food:");
		System.out.println("4.Get all Food:");
		System.out.println("5.Search by Food Id:");
		System.out.println("6.Search by FoodName:");
		System.out.println("7.Search by Image:");
		
		int choice =sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
		{
			System.out.println("Enter the food name:");
			String foodName=sc.nextLine();
			
			System.out.println("Enter the food Type:");
			String foodType=sc.nextLine();
			
			System.out.println("Enter the food Category:");
			String foodCategory=sc.nextLine();
			
			System.out.println("Enter the food Desc:");
			String foodDesc=sc.nextLine();
			
			System.out.println("Enter the food Price:");
			double foodPrice=sc.nextDouble();
			
			System.out.println("Enter the food Image:");
			String image=sc.nextLine();
			
			Food f1=new Food(foodName, foodType, foodCategory, foodDesc, foodPrice, image);
			boolean b=fdao.addFood(f1);
			if(b) {
				System.out.println("Food Added Successfully.");
			}else {
				System.out.println("Food not Added");
			}
			break;
		}
		case 2:{
			System.out.println("Enter foodId:");
			int foodId=sc.nextInt();
			boolean b=fdao.deleteFood(foodId);
			if(b) {
				System.out.println("Successfully deleted");
			}else {
				System.out.println("Data not deleted.");
			}
			break;
		}
		case 3:{
			System.out.println("Enter the foodId to update:");
			int foodId=sc.nextInt();sc.nextLine();
			
			System.out.println("Enter the food name:");
			String foodName=sc.nextLine();
			
			System.out.println("Enter the food type:");
			String foodType=sc.nextLine();
			
			System.out.println("Enter the food category:");
			String foodCategory=sc.nextLine();
			
			System.out.println("Enter the food Description:");
			String foodDesc=sc.nextLine();
			
			System.out.println("Enter the food Price:");
			double foodPrice=sc.nextDouble();
			
			System.out.println("Enter the food Image:");
			String image=sc.nextLine();
			f.setFoodId(foodId);
			f.setFoodName(foodName);
			f.setFoodType(foodType);
			f.setFoodCategory(foodCategory);
			f.setFoodDesc(foodDesc);
			f.setFoodPrice(foodPrice);
			f.setImage(image);
			boolean b=fdao.updateFood(f);
			if(b) {
				System.out.println("Successfully updated.");
			}else {
				System.out.println("Upadte unsuccessfull.");
			}
			break;
		}
		case 4:{
			
			List<Food> l=fdao.getAllFood();
			if(l!=null) {
				Iterator <Food> it=l.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			break;
		}
		case 5:{
			System.out.println("Enter foodId:");
			int foodId=sc.nextInt();
			Food  f3=fdao.searchFood(foodId);
			if(f3!=null) {
				System.out.println(f3);
			}else {
				System.out.println("Data not available!!!");
			}
		break;	
		}
		case 6:{
			System.out.println("Enter the food name to search food:");
			String foodName=sc.nextLine();
			List<Food> l=fdao.searchFoodByname(foodName);
			if(l!=null) {
				Iterator<Food> it=l.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			else {
				System.out.println("Data not found!!!");
			}
			break;
		}
		case 7:{
			System.out.println("Enter category to search food:");
			String foodCategory=sc.nextLine();
			List<Food>li=fdao.searchFoodByCategory(foodCategory);
			if(li!=null) {
				Iterator<Food> it=li.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			else {
				System.out.println("Food not found!!!");
			}
		}
		case 100:
			return;
			default:System.out.println("Invalid input!!!");
		
		
		}

	}

}
