package DAO;

public interface LoginDao {
	boolean userLogin(String emailId, String CPassword);
	boolean userChangedPassword(String EmailId, String newPassword);
	boolean adminLogin(String adminName,String adminPassword);
	boolean adminChangePassword(String adminUserName, String adminNewPassword);

}
