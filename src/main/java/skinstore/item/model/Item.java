package skinstore.item.model;

public class Item {
	private int price;
	private String name;
	private String category;
	private long id;
	private double size;
	private String brandName;
	private int stock;
	private String img;
	private String detail;
	//private String ingredients;
	private int love;
	public Item(){
		
	}
	public  Item(int price, String name, String category, long id, double size, String brandName, int stock, String img, String detail, int love ){
		this.price = price;
		this.name = name;
		this.category = category;
		this.id = id;
		this.size= size;
		this.brandName = brandName;
		this.stock = stock;
		this.img = img;
		this.detail = detail;
		this.love = love;
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	

}
