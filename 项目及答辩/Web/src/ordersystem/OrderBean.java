package ordersystem;

public class OrderBean {
	private int orderId;
	private String foodName;
	private String userName;
	private String userPhonenum;
	private String userAddress;
	private int foodQuantity;
	private int foodSinglePrice;
	private int foodSumPrice;
	private String orderTime;
	private String orderDeliver;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhonenum() {
		return userPhonenum;
	}
	public void setUserPhonenum(String userPhonenum) {
		this.userPhonenum = userPhonenum;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public int getFoodSinglePrice() {
		return foodSinglePrice;
	}
	public void setFoodSinglePrice(int foodSinglePrice) {
		this.foodSinglePrice = foodSinglePrice;
	}
	public int getFoodSumPrice() {
		return foodSumPrice;
	}
	public void setFoodSumPrice(int foodSumPrice) {
		this.foodSumPrice = foodSumPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderDeliver() {
		return orderDeliver;
	}
	public void setOrderDeliver(String orderDeliver) {
		this.orderDeliver = orderDeliver;
	}
	
	

}
