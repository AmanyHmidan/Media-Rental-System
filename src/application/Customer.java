package application;
import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	private String name;
	private String address;
	private String id;
	private String mobile;
	private String plan;
	private int value;   //the number of media associated with the LIMITED plan
	// cart list represents the media that customer is interested in receiving
	private ArrayList<String> cart = new ArrayList<>(); 
	//rented list represents the media already received (rented) by the customer
	private ArrayList<String> rented = new ArrayList<>();
	
	
	public Customer(String id,String name, String address,String mobile, String plan) {
		this.id=id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		setPlan(plan);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		if(plan.equals("LIMITED")) {
			value=2;
			this.plan=plan;
		}
			
		else if(plan.equals("UNLIMITED"))
			this.plan=plan;
		else
			throw new IllegalArgumentException("plan must be LIMITED or UNLIMITED");					
		
	}
	private String getRequestedMedia() {
		String ren="";
		for(int i=0; i<cart.size(); i++) {
			ren += cart.get(i) + ",";
		}
		return ren;
	}
	private String getRentedMedia() {
		String ren="";
		for(int i=0; i<rented.size(); i++) {
			ren += rented.get(i) + ",";
		}
		return ren;
	}
	
	@Override
	public String toString() {
		return "Customer [id="+ id +", name=" + name + ", address=" + address + ", mobile number="+ mobile+ ", plan=" + plan + ", Rented media="+getRentedMedia()+", media in cart="+getRequestedMedia()+"]";
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ArrayList<String> getCart() {
		return cart;
	}
	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}
	public ArrayList<String> getRented() {
		return rented;
	}
	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}
	
	@Override
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	
	
	
	

}
