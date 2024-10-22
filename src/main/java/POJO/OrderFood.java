package POJO;

import java.time.LocalDateTime;

public class OrderFood {
	private int orderId;
	private LocalDateTime orderDate;
	private double totalBill;
	private String emailId;
	private String orderStatus;
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public OrderFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderFood(int orderId, LocalDateTime orderDate, double totalBill, String emailId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
		this.emailId = emailId;
		this.orderStatus = orderStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "OrderFood [orderId=" + orderId + ", orderDate=" + orderDate + ", totalBill=" + totalBill + ", emailId="
				+ emailId + ", orderStatus=" + orderStatus + "]";
	}
	
	

}
