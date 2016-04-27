package consumer;

public class PersoneClient {
	private double discount;
	private double takeout;
	private double service;
	private double prepDistance;
	private double spendMoney;
	private double slowDelivery;
	private double green;
	private double budget;
	
	private int Xcoord;
	private int Ycoord;
	private int regio;
	
	

	public PersoneClient(double discount, double takeout, double service, double prepDistance, double spendMoney, double slowDelivery,
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
	
	
	
	
}
