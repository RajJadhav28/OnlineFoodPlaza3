package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DAO.CustomerDao;
import POJO.Customer;
import Utility.DButility;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public boolean addCustomer(Customer C) {
Connection con=DButility.getConnect();
		
		try {
			String sql="insert into customer(custName,emailId,custPassword,contactNo,custLocation)values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, C.getCustName());
			ps.setString(2, C.getEmailId());
			ps.setString(3, C.getCustPassword());
			ps.setString(4, C.getContactNo());
			ps.setString(5, C.getCustLocation());
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
	public boolean deleteCustomer(String EmailId) {
Connection con=DButility.getConnect();
		
		
		try {
			String sql="delete from customer where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, EmailId);
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
	public boolean updateCustomer(Customer C) {
		Connection con=DButility.getConnect();
		try {
			String sql="update customer set custName=?,custPassword=?,contactNo=?,custLocation=? where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, C.getCustName());
			ps.setString(2, C.getCustPassword());
			ps.setString(3, C.getContactNo());
			ps.setString(4, C.getCustLocation());
			ps.setString(5, C.getEmailId());
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
	public List<Customer> searchByEmail(String EmailId) {
		Connection con=DButility.getConnect();
		List<Customer>li=new ArrayList<Customer>();
		
		try {
			String sql="select * from customer where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, EmailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c1=new Customer();
				c1.setCustName(rs.getString(1));
				c1.setEmailId(rs.getString(2));
				c1.setCustPassword(rs.getString(3));
				c1.setContactNo(rs.getString(4));
				c1.setCustLocation(rs.getString(5));
				li.add(c1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Connection con=DButility.getConnect();
		List<Customer>li=new  ArrayList<Customer>();
		
		try {
			String sql="select * from customer";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c1=new Customer();
				c1.setCustName(rs.getString(1));
				c1.setEmailId(rs.getString(2));
				c1.setCustPassword(rs.getString(3));
				c1.setContactNo(rs.getString(4));
				c1.setCustLocation(rs.getString(5));
				li.add(c1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}

	
	
	

}
