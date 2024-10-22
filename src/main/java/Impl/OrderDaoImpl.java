package Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DAO.OrderDao;
import POJO.OrderFood;
import Utility.DButility;

public class OrderDaoImpl implements OrderDao{
	
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<OrderFood>olist=null;
	
	private int orderId;
	private LocalDateTime orderDate;
	private double totalBill;
	private String emailId;
	private String orderStatus;

	@Override
	public boolean placeOrder(OrderFood o) {
		LocalDateTime dt=LocalDateTime.now();//to get current date and time
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String formattedDateTime=dt.format(format);
		totalBill=calculateBill(o.getEmailId());
		con=DButility.getConnect();
		sql="insert into orderfood(orderDate, totalBill, emailId, orderStatus) values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setTimestamp(1, Timestamp.valueOf(formattedDateTime));
			ps.setDouble(2, totalBill);
			ps.setString(3, o.getEmailId());
			ps.setString(4, o.getOrderStatus());
			int i=ps.executeUpdate();
			if(i>0) {
				//new CartDaoImpl().deleteCartByEmail(o.getEmailId());
				return true;
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	private double calculateBill(String cEmail) {
		con=DButility.getConnect();
		sql="select totalPrice from cart where cEmail=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, cEmail);
			rs=ps.executeQuery();
			totalBill=0;
			while(rs.next()) {
				totalBill+=rs.getDouble("totalPrice");
			}
			return totalBill;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public OrderFood showOrderById(int orderId) {
		Connection con=DButility.getConnect();
		OrderFood f3=null;
		
		try {
			String sql="select * from orderfood where orderId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				f3=new OrderFood();
				f3.setOrderId(rs.getInt(1));
				f3.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				f3.setTotalBill(rs.getDouble(3));
				f3.setEmailId(rs.getString(4));
				f3.setOrderStatus(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f3;
	}

	@Override
	public List<OrderFood> showAllOrder() {
		con= DButility.getConnect();
		List<OrderFood>li=new ArrayList<OrderFood>();
		sql="select * from orderfood;";
		
		try {
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				OrderFood o=new OrderFood();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				li.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public boolean changeOrderStatus(String orderStatus, int orderId) {
		Connection con=DButility.getConnect();
		
		try {
			String sql="update orderfood set orderStatus=? where orderId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, orderStatus);
			ps.setInt(2, orderId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<OrderFood> showMyOrderHistory(String email) {
		con=DButility.getConnect();
		sql="select * from orderfood where emailId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			olist=new ArrayList<>();
			while(rs.next()) {
				OrderFood o=new OrderFood();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getTimestamp(2).toLocalDateTime());
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				olist.add(o);
			}
			return olist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
