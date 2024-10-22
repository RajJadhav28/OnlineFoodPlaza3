package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import POJO.Cart;
import POJO.Food;
import Utility.DButility;
import DAO.CartDao;

public class CartDaoImpl implements CartDao{
	
	Connection con=null;
	ResultSet rs=null;
	boolean flag;
	String sql;
	int row;
	PreparedStatement pst=null;
	List<Cart> cartlist=new LinkedList<>();
	
	@Override
	public boolean addToCart(Cart cart) {
		con=DButility.getConnect();
		sql="insert into Cart(foodId, fPrice, fquantity, totalPrice,cEmail, fname)values(?,?,?,?,?,?)";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, cart.getFoodid());
			Food f=new FoodDaoImpl().searchFood(cart.getFoodid());
			pst.setDouble(2, f.getFoodPrice());
			pst.setInt(3, cart.getFquantity());
			
			double totalPrice=f.getFoodPrice()*cart.getFquantity();
			
			pst.setDouble(4, totalPrice);
			pst.setString(5, cart.getcEmail());
			pst.setString(6, f.getFoodName());
			
			row=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(row>0) {
			return true;
		}else {
			return false;
		}
		//return false;
	}

	@Override
	public List<Cart> showCartList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> searchCartByEmailId(String cEmail) {
		con=DButility.getConnect();
		sql="select * from cart where cEmail=?";
		try {
			
			pst=con.prepareStatement(sql);
			pst.setString(1, cEmail);
			rs=pst.executeQuery();
			List<Cart> clist=new LinkedList<>();
			while(rs.next()) {
				Cart ca=new Cart();
				ca.setCartid(rs.getInt("cartid"));
				ca.setcEmail(rs.getString("cEmail"));
				ca.setFname(rs.getString("fname"));
				ca.setFoodid(rs.getInt("foodId"));
				ca.setFprice(rs.getDouble("fPrice"));
				ca.setFquantity(rs.getInt("fquantity"));
				ca.setTotalPrice(rs.getDouble("totalPrice"));
				clist.add(ca);
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Cart searchCartById(int cartid) {
		con=DButility.getConnect();
		sql="select * from cart where cartId=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, cartid);
			rs=pst.executeQuery();
			while(rs.next()) {
				Cart ca=new Cart();
				ca.setCartid(rs.getInt(cartid));
				ca.setcEmail(rs.getString("cEmail"));
				ca.setFname(rs.getString("fname"));
				ca.setFoodid(rs.getInt("foodId"));
				ca.setFprice(rs.getDouble("fprice"));
				ca.setFquantity(rs.getInt("fquantity"));
				ca.setTotalPrice(rs.getDouble("totalPrice"));
				return ca;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCartById(int cartid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCartByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCart(int cartid, int fquantity) {//1
		con=DButility.getConnect();
		sql="update cart set fquantity=? where cartid=?";
		try {//2 try
			pst=con.prepareStatement(sql);
			pst.setInt(1, fquantity);
			pst.setInt(2, cartid);
			row=pst.executeUpdate();
			if(row>0) {//if
				Cart c=searchCartById(cartid);
				double totalPrice=c.getFprice()*c.getFquantity();
				sql="update cart set totalPrice=? where cartid=?";
				try {
				pst=con.prepareStatement(sql);
				pst.setDouble(1, totalPrice);
				pst.setDouble(2, cartid);
				
				int row2=pst.executeUpdate();
				if(row2>0) {
					return true;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}			
				}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	
}
