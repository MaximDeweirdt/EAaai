package simulator;

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
			if(personClient.getSpendMoney() >= valueSpendMoney){
				personClient.setAcceptOrder(true);
			}else{//if not accepted, check with Blotzmann
				personClient.setAcceptOrder(boltzmannCheck(personClient.getSpendMoney(),valueSpendMoney));
			}
			
			
			
			if(personClient.isAcceptOrder())amountAccepted++;
		}
		System.out.println(amountAccepted);
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
