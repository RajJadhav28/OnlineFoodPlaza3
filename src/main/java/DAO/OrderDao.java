package DAO;

import java.util.List;

import POJO.OrderFood;

public interface OrderDao {
	boolean placeOrder(OrderFood o);
	OrderFood showOrderById(int orderId);
	List<OrderFood>showAllOrder();
	public boolean changeOrderStatus(String orderStatus, int orderId);
	public List<OrderFood>showMyOrderHistory(String email);

}
