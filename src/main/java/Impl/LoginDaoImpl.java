package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.LoginDao;
import Utility.DButility;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean userLogin(String emailId, String CPassword) {
Connection con=DButility.getConnect();
		
		try {
			String sql="select * from customer where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String pass=rs.getString("custPassword");
				if(pass.equals(CPassword)) {
					return true;
				}else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userChangedPassword(String EmailId, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adminLogin(String adminName, String adminPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adminChangePassword(String adminUserName, String adminNewPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
