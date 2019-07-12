package Do;

public class commodity {
	private String name;
	private String price;	
	private String image;
	

public commodity(String name, String price, String image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getSize() {
	return name;
}
public void setSize(String name) {
	this.name = name;
}

}