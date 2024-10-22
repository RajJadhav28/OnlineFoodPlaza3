package POJO;

public class Customer {
	private String custName;
	private String emailId;
	private String custPassword;
	private String contactNo;
	private String custLocation;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String custName, String emailId, String custPassword, String contactNo, String custLocation) {
		super();
		this.custName = custName;
		this.emailId = emailId;
		this.custPassword = custPassword;
		this.contactNo = contactNo;
		this.custLocation = custLocation;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCustLocation() {
		return custLocation;
	}
	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", emailId=" + emailId + ", custPassword=" + custPassword
				+ ", contactNo=" + contactNo + ", custLocation=" + custLocation + "]";
	}
	
	

}
