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
	
	@Override
	public void setData(double discountOffset,double  discountTakeoutOffset, double serviceOffset, double prepDistanceOffset, double spendMoneyOffset, double slowDeliveryOffset, double greenOffset, double budgetOffset){
			this.discount = discountStartValue + discountOffset;
			this.takeout = takeoutStartValue + discountTakeoutOffset;
			this.service = serviceStartValue + serviceOffset;
			this.prepDistance = prepDistanceStartValue + prepDistanceOffset;
			this.spendMoney = spendMoneyStartValue + spendMoneyOffset;
			this.slowDelivery = slowDeliveryStartValue + slowDeliveryOffset;
			this.green = greenStartValue + greenOffset;
			this.budget = budgetStartValue + budgetOffset;			
	}
	
	@Override
	public double getBudgetStartValue() {
		return budgetStartValue;
	}

	@Override
	public void setBudgetStartValue(double budgetStartValue) {
	}

	@Override
	public double getBudgetEndValue() {
		return budgetEndValue;
	}

	@Override
	public void setBudgetEndValue(double budgetEndValue) {
	}
}
