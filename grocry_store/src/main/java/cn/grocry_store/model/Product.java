package cn.grocry_store.model;

public class Product {
	
	private String name;
	private String building;
	private int consumption;
	;
	
	
	public Product() {
	}
	
	public Product( String name, String building, int consumption) {
		super();

		this.name = name;
		this.building= building;
		this.consumption = consumption;
	
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return building;
	}

	public void setDescription(String building) {
		this.building = building;
	}
	
	
	public int getPrice() {
		return consumption;
	}

	public void setPrice(int consumption) {
		this.consumption = consumption;
	}
	
	
	
	@Override
	public String toString() {
		return "Product [name=" + name+ ", description=" + building+ ", price=" + consumption+  "]";
	}
	
	
}
