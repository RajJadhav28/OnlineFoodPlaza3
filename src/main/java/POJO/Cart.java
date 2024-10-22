package POJO;

public class Cart {
	private int cartid;
	private int foodid;
	private String cEmail;
	private int fquantity;
	private String fname;
	private double fprice;
	private double totalPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Cart(int cartid, int foodid, String cEmail, int fquantity, String fname, double fprice) {
		super();
		this.cartid = cartid;
		this.foodid = foodid;
		this.cEmail = cEmail;
		this.fquantity = fquantity;
		this.fname = fname;
		this.fprice = fprice;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int foodid, String cEmail, int fquantity) {
		super();
		this.foodid = foodid;
		this.cEmail = cEmail;
		this.fquantity = fquantity;
	}
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public int getFquantity() {
		return fquantity;
	}
	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getFprice() {
		return fprice;
	}
	public void setFprice(double fprice) {
		this.fprice = fprice;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", foodid=" + foodid + ", cEmail=" + cEmail + ", fquantity=" + fquantity
				+ ", fname=" + fname + ", fprice=" + fprice + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	

}
