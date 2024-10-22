package DAO;

import java.util.List;

import POJO.Customer;



public interface CustomerDao {
	boolean addCustomer(Customer C);
	boolean deleteCustomer(String EmailId);
	boolean updateCustomer(Customer C);
	List<Customer> searchByEmail(String EmailId);
	List<Customer> getAllCustomer();

}
