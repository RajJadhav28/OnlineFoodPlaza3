package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.FoodDao;
import POJO.Food;
import Utility.DButility;

public class FoodDaoImpl implements FoodDao{

	@Override
	public boolean addFood(Food f) {
		Connection con=DButility.getConnect();
		
		try {
			String sql="insert into food(foodName,foodType,foodCategory,foodDesc,foodPrice,image)values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setString(4, f.getFoodDesc());
			ps.setDouble(5, f.getFoodPrice());
			ps.setString(6, f.getImage());
			int i=ps.executeUpdate();
			if(i>0) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFood(Food f) {
		Connection con=DButility.getConnect();
		try {
			String sql="update Food set foodName=?,foodType=?,foodCategory=?,foodDesc=?,foodPrice=?,image=? where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setString(4, f.getFoodDesc());
			ps.setDouble(5, f.getFoodPrice());
			ps.setString(6, f.getImage());
			ps.setInt(7, f.getFoodId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		Connection con=DButility.getConnect();
		try {
			String sql="delete from Food where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Food searchFood(int foodId) {
		Connection con=DButility.getConnect();
		Food f1=null;
		try {
			String sql="select * from food where foodId=?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getDouble(6));
				f1.setImage(rs.getString(7));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f1;
	}

	@Override
	public List<Food> getAllFood() {
		Connection con=DButility.getConnect();
		List<Food>l=new ArrayList<Food>();
		try {
			String sql="select * from food";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 Food f=new Food();
				 f.setFoodId(rs.getInt(1));
				 f.setFoodName(rs.getString(2));
				 f.setFoodType(rs.getString(3));
				 f.setFoodCategory(rs.getString(4));
				 f.setFoodDesc(rs.getString(5));
				 f.setFoodPrice(rs.getDouble(6));
				 f.setImage(rs.getString(7));
				 l.add(f);
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Food> searchFoodByname(String foodName) {
		Connection con=DButility.getConnect();
		List<Food>l=new ArrayList<Food>();
		
		try {
			String sql="select * from food where foodName=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food f1=new Food();
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodType(rs.getString(3));
				f1.setFoodCategory(rs.getString(4));
				f1.setFoodDesc(rs.getString(5));
				f1.setFoodPrice(rs.getDouble(6));
				f1.setImage(rs.getString(7));
				l.add(f1);
			}
			if(l.isEmpty()) {
				System.out.println("No data found for Name:"+foodName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Food> searchFoodByCategory(String Category) {
		Connection con=DButility.getConnect();
		List<Food> li=new ArrayList<Food>();
		
		try {
			String sql="select * from food where foodCategory=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Category);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
				f.setFoodType(rs.getString(3));
				f.setFoodCategory(rs.getString(4));
				f.setFoodDesc(rs.getString(5));
				f.setFoodPrice(rs.getDouble(6));
				f.setImage(rs.getString(7));
				li.add(f);
			}
			if(li.isEmpty()) {
				System.out.println("No data found for category:"+Category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

}
