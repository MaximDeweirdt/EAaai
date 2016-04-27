package consumer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RichPeople extends PersonClient{

	private double discountStartValue = 0.05;
	private double takeoutStartValue = 0.05;
	private double serviceStartValue = 0.85;
	private double prepDistanceStartValue = 0.1;
	private double spendMoneyStartValue = 0.1;
	private double slowDeliveryStartValue = 0;
	private double greenStartValue = 0.1;
	private double budgetStartValue = 150000;
	private double budgetEndValue = 300000;
	
	public RichPeople(){}
	
	public RichPeople(double discount, double takeout, double service, double prepDistance, double spendMoney,
			double slowDelivery, double green, double budget) {
		super(discount, takeout, service, prepDistance, spendMoney, slowDelivery, green, budget);
		// TODO Auto-generated constructor stub
	}
	
	public void setData(double discount, double takeout, double service, double prepDistance, double spendMoney,
			double slowDelivery, double green, double budget){
			this.discount = discount;
			this.takeout = takeout;
			this.service = service;
			this.prepDistance = prepDistance;
			this.spendMoney = spendMoney;
			this.slowDelivery = slowDelivery;
			this.green = green;
			this.budget = budget;			
	}
}
