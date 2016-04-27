package consumer;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class OldPeople extends PersonClient{
	private double discountStartValue = 0.3;
	private double takeoutStartValue = 0.7;
	private double serviceStartValue = 0.4;
	private double prepDistanceStartValue = 0.25;
	private double spendMoneyStartValue = 0.05;
	private double slowDeliveryStartValue = 0.50;
	private double greenStartValue = 0.20;
	private double budgetStartValue = 50000;
	private double budgetEndValue = 100000;
	
	
	public OldPeople(){}
	
	public OldPeople(double discount, double takeout, double service, double prepDistance, double spendMoney,
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
