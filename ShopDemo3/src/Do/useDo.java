package Do;

import java.util.ArrayList;
import java.util.List;

public class useDo {
private String  name;
private String  password;

private String  adresss;
private String  iphone;





public String getAdresss() {
	return adresss;
}
public void setAdresss(String adresss) {
	this.adresss = adresss;
}
public String getIphone() {
	return iphone;
}
public void setIphone(String iphone) {
	this.iphone = iphone;
}
private   shoppingCar car;
public useDo(String name, String password) {
	super();
	this.name = name;
	this.password = password;
	
}
public useDo() {
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public shoppingCar getCar() {
	return car;
}
public void setCar(shoppingCar car) {
	this.car = car;
}





}
