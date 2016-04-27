package consumer;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class YoungPeople extends PersonClient {
	private double discountStartValue = 0.7;
	private double takeoutStartValue = 0.5;
	private double serviceStartValue = 0.65;
	private double prepDistanceStartValue = 0.25;
	private double spendMoneyStartValue = 0.15;
	private double slowDeliveryStartValue = 0.50;
	private double greenStartValue = 0.20;
	private double budgetStartValue = 500;
	private double budgetEndValue = 2000;
	
	public YoungPeople(){}
	
	public YoungPeople(double discount, double takeout, double service, double prepDistance, double spendMoney,
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
