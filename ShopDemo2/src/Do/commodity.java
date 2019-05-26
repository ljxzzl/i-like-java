package Do;

public class commodity {
	private String image;
	private String price;
	public commodity(String image, String price, String size) {
		super();
		this.image = image;
		this.price = price;
		this.name = size;
	}
	private String name;
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
public void setSize(String size) {
	this.name = size;
}
}
