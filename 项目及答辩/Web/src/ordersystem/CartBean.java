package ordersystem;

public class CartBean {
	
	private String order_id ;
	private int  food_id ;
	private String  food_name ;
	private int food_single_price ;
	private int food_quantity;
	private String user_name;
	public String setfood_name(String name) {
		return food_name=name;
	}	
	public String getfood_name() {
		return food_name;
	}
	public String setuser_name(String name) {
		return user_name=name;
	}
	public String getuser_name(String name) {
		return user_name=name;
	}
	public String getuser_id() {
		return order_id;
	}
	public void setfood_quantity(int a) {
		this.food_quantity=a;
	}
	public int  getfood_quantity() {
		return food_quantity;
	}
	public void setorder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public int getfood_id() {
		return food_id;
	}
	
	public void setfood_id(int food_id) {
		this.food_id = food_id;
	}
	
	public int getfood_single_price() {
		return food_single_price;
	}
	
	public void setfood_single_price( int food_single_price) {
		this.food_single_price = food_single_price;
	}
	
	
}
	



