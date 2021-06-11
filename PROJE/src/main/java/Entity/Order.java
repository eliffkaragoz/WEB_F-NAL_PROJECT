package Entity;

public class Order {
	
	private int orderCode;
	private String orderDate;  
	private String delivery;
	private String paymentType;
	private String memberUsername;
	
	public Order ( int orderCode, String orderDate, String delivery, String paymentType, String memberUsername ) {
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.delivery= delivery;
		this.paymentType = paymentType;
		this.memberUsername = memberUsername;
	}
	
	public Order ( String orderDate, String delivery, String paymentType, String memberUsername ) {
		super();
		this.orderDate = orderDate;
		this.delivery = delivery;
		this.paymentType = paymentType;
		this.memberUsername = memberUsername;
	}

	public Order ( int orderCode, String orderDate, String delivery, String paymentType ) {
		super();
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.delivery = delivery;
		this.paymentType = paymentType;
	}
	
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getMemberUsername() {
		return memberUsername;
	}
	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}
}
