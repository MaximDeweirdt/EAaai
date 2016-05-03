package order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType (XmlAccessType.FIELD)
public class Order {
	protected double discount;
	protected double takeout;
	protected double service;
	protected double prepDistance;
	protected double spendMoney;
	protected double slowDelivery;
	protected double green;
	protected double price;
	protected int xCoordFirm;
	protected int yCoordFirm;
	
	
	public Order(){}
	
	public Order(double discount, double takeout, double service, double prepDistance, double spendMoney,
			double slowDelivery, double green, double price) {
		super();
		this.discount = discount;
		this.takeout = takeout;
		this.service = service;
		this.prepDistance = prepDistance;
		this.spendMoney = spendMoney;
		this.slowDelivery = slowDelivery;
		this.green = green;
		this.price = price;
		this.xCoordFirm = xCoordFirm;
		this.yCoordFirm = yCoordFirm;
	}
	
	public void setData(double discount,double discountTakeout,double service,double prepDistance,double spendMoney,
			double slowDelivery,double green,double price) {
		this.discount = discount;
		this.takeout = discountTakeout;
		this.service = service;
		this.prepDistance = prepDistance;
		this.spendMoney = spendMoney;
		this.slowDelivery = slowDelivery;
		this.green = green;
		this.price = price;		
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		if(discount>0.4) discount = 0.4;
		if(discount<0.2) discount = 0.2;
		this.discount = discount;
	}
	
	public double getTakeout() {
		return takeout;
	}
	
	public void setTakeout(double takeout) {
		if(takeout>0.8) takeout = 0.8;
		if(takeout<0.2) takeout = 0.2;
		this.takeout = takeout;
	}
	
	public double getService() {
		return service;
	}
	
	public void setService(double service) {
		this.service = service;
	}
	
	public double getPrepDistance() {
		return prepDistance;
	}
	
	public void setPrepDistance(double prepDistance) {
		this.prepDistance = prepDistance;
	}
	
	public double getSpendMoney() {
		return spendMoney;
	}
	
	public void setSpendMoney(double spendMoney) {
		this.spendMoney = spendMoney;
	}
	
	public double getSlowDelivery() {
		return slowDelivery;
	}
	
	public void setSlowDelivery(double slowDelivery) {
		this.slowDelivery = slowDelivery;
	}
	
	public double getGreen() {
		return green;
	}
	
	public void setGreen(double green) {
		this.green = green;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getxCoordFirm() {
		return xCoordFirm;
	}
	
	public void setxCoordFirm(int xCoordFirm) {
		this.xCoordFirm = xCoordFirm;
	}
	
	public int getyCoordFirm() {
		return yCoordFirm;
	}
	
	public void setyCoordFirm(int yCoordFirm) {
		this.yCoordFirm = yCoordFirm;
	}
	
	@Override
	public String toString() {
		return "Order [discount=" + discount + ", takeout=" + takeout + ", service=" + service + ", prepDistance="
				+ prepDistance + ", spendMoney=" + spendMoney + ", slowDelivery=" + slowDelivery + ", green=" + green
				+ ", price=" + price + ", xCoordFirm=" + xCoordFirm + ", yCoordFirm=" + yCoordFirm + "]";
	}


}
