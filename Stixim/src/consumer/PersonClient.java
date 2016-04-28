package consumer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import order.Order;

@XmlRootElement(name = "personClient")
@XmlAccessorType (XmlAccessType.FIELD)
public class PersonClient {
	protected double discount;
	protected double takeout;
	protected double service;
	protected double prepDistance;
	protected double spendMoney;
	protected double slowDelivery;
	protected double green;
	protected double budget;
	
	protected int Xcoord;
	protected int Ycoord;
	protected int regio;
	
	private Order order;
	private boolean acceptOrder = false;
	private boolean lateDelivery = false;
	private boolean takeoutBoolean = false;
	private boolean deliveryAtHome = false;
	
	public PersonClient(){}

	public PersonClient(double discount, double takeout, double service, double prepDistance, double spendMoney, double slowDelivery,
			double green, double budget) {
		super();
		this.discount = discount;
		this.takeout = takeout;
		this.service = service;
		this.prepDistance = prepDistance;
		this.spendMoney = spendMoney;
		this.slowDelivery = slowDelivery;
		this.green = green;
		this.budget = budget;
	}
	
	public void setData(double discount, double takeout, double service, double prepDistance, double spendMoney,
			double slowDelivery, double green, double budget){
		
	}
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTakeout() {
		return takeout;
	}
	public void setTakeout(double takeout) {
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
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getXcoord() {
		return Xcoord;
	}

	public void setXcoord(int xcoord) {
		Xcoord = xcoord;
	}

	public int getYcoord() {
		return Ycoord;
	}

	public void setYcoord(int ycoord) {
		Ycoord = ycoord;
	}

	public int getRegio() {
		return regio;
	}

	public void setRegio(int regio) {
		this.regio = regio;
	}

	public double getBudgetStartValue() {
		return 0;
	}

	public void setBudgetStartValue(double budgetStartValue) {
	}

	public double getBudgetEndValue() {
		return 0;
	}

	public void setBudgetEndValue(double budgetEndValue) {
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isAcceptOrder() {
		return acceptOrder;
	}

	public void setAcceptOrder(boolean acceptOrder) {
		this.acceptOrder = acceptOrder;
	}

	public boolean isLateDelivery() {
		return lateDelivery;
	}

	public void setLateDelivery(boolean lateDelivery) {
		this.lateDelivery = lateDelivery;
	}

	public boolean isTakeoutBoolean() {
		return takeoutBoolean;
	}

	public void setTakeoutBoolean(boolean takeoutBoolean) {
		this.takeoutBoolean = takeoutBoolean;
	}
	

	public boolean isDeliveryAtHome() {
		return deliveryAtHome;
	}

	public void setDeliveryAtHome(boolean deliveryAtHome) {
		this.deliveryAtHome = deliveryAtHome;
	}

	@Override
	public String toString() {
		return "PersonClient [acceptOrder=" + acceptOrder + ", lateDelivery=" + lateDelivery + ", takeoutBoolean="
				+ takeoutBoolean + ", deliveryAtHome=" + deliveryAtHome + "]";
	}


	
	
	
	
}
