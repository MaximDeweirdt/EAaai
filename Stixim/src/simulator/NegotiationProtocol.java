package simulator;

import java.util.List;
import java.util.Map;
import java.util.Random;

import consumer.PersonClient;
import order.Order;

public class NegotiationProtocol {
	
	double T = 10;//hoe hoger T, hoe groter de kans dat iets geaccepteerd zal worden bij de boltmannvergelijking
	Random rand = new Random();
	int amountAccepted = 0;
	public void negotiate(Solution solution){
		for(PersonClient personClient:solution.getPersonList()){
			Order order = personClient.getOrder();
			double valueSpendMoney = order.getPrice()/personClient.getBudget();
			boolean acceptedOrder;
			if(personClient.getSpendMoney() >= valueSpendMoney){
				acceptedOrder = true;
				personClient.setAcceptOrder(acceptedOrder);
			}else{//if not accepted, check with Blotzmann
				acceptedOrder = boltzmannCheck(personClient.getSpendMoney(),valueSpendMoney);
				personClient.setAcceptOrder(acceptedOrder);
			}
			double valueTakeout = 0;
			double valueDelayedDelivery = 0;
			if(acceptedOrder){
				double distance = Math.sqrt((personClient.getXcoord() - order.getxCoordFirm())*(personClient.getXcoord() - order.getxCoordFirm())
						+ (personClient.getYcoord() - order.getyCoordFirm())*(personClient.getYcoord() - order.getyCoordFirm()));
				valueTakeout = (personClient.getTakeout() - order.getTakeout()) + (personClient.getGreen() - order.getGreen()) + (personClient.getPrepDistance()) - (distance)/100*3;
				valueTakeout = valueTakeout;
				valueDelayedDelivery = (-order.getDiscount() + personClient.getDiscount());
				//System.out.println(valueTakeout + " " + valueDelayedDelivery);
			if(valueTakeout<valueDelayedDelivery){
				boolean check = boltzmannCheck(valueDelayedDelivery, 0);
				if(valueDelayedDelivery>valueSpendMoney)personClient.setLateDelivery(true);
				/*else if(check){
					personClient.setLateDelivery(true);
				}*/
				else personClient.setDeliveryAtHome(true);
			}else{
				boolean check = boltzmannCheck(valueTakeout, 0);
				if(valueTakeout>valueSpendMoney*3)personClient.setTakeoutBoolean(true);
				else if(check){
					personClient.setTakeoutBoolean(true);
				}
				else personClient.setDeliveryAtHome(true);
			}
			}
			
			
			
			if(personClient.isAcceptOrder())amountAccepted++;
			
			//update prijzen indien de order in de eerste stap niet geaccepteerd is
			if(!acceptedOrder){
				double price = order.getPrice() - 1;
				order.setPrice(price);
			}else{
				double price = order.getPrice() + 1;
				order.setPrice(price);
			}
			
			if(personClient.isTakeoutBoolean()){
				double orderTakeoutValue = order.getTakeout() - 0.001;
				order.setTakeout(orderTakeoutValue);
				//update the other people to takeout
				Map<Integer, List<PersonClient>> personMap = solution.getPersonMap();
				    List<PersonClient> personList = personMap.get(personClient.getRegio());
				    for(PersonClient person:personList){
				    	double valueGreen = person.getGreen() + 0.000001;
				    	person.setGreen(valueGreen);
				    }
			}else{
				double orderTakeoutValue = order.getTakeout() + 0.001;
				order.setTakeout(orderTakeoutValue);
			}
			
			if(personClient.isLateDelivery()){
				double discountOrder = order.getDiscount() + 0.1;
				order.setDiscount(discountOrder);
			}else{
				double discountOrder = order.getDiscount() - 0.1;
				order.setDiscount(discountOrder);
			}
		}
	}

	private boolean boltzmannCheck(double valueClient, double valueCondition) {
		boolean accept = false;
		double boltzmannValue = Math.exp(((valueClient-valueCondition)*100)/T);
		double randomValue = rand.nextDouble();
		if(boltzmannValue>randomValue){
			accept = true;
		}
		return accept;
	}
}
