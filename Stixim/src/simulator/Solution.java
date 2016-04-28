package simulator;

import java.util.ArrayList;
import java.util.List;

import consumer.PersonClient;
import order.Order;

public class Solution {
	List<Order> orderList;
	List<PersonClient> personList;
	List<PersonClient> area0;
	List<PersonClient> area1;
	List<PersonClient> area2;
	List<PersonClient> area3;
		
	public Solution(List<Order> orderList, List<PersonClient> personList) {
		super();
		this.orderList = orderList;
		this.personList = personList;
		area0 = new ArrayList<>();
		area1 = new ArrayList<>();
		area2 = new ArrayList<>();
		area3 = new ArrayList<>();
		for(PersonClient personClient:personList){
			if(personClient.getRegio() == 0){
				area0.add(personClient);
			}else if(personClient.getRegio() == 1){
				area1.add(personClient);
			}else if(personClient.getRegio() == 2){
				area2.add(personClient);
			}else if(personClient.getRegio() == 3){
				area3.add(personClient);
			}else{
				System.err.println("ERROR IN AREA");
			}
		}
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public List<PersonClient> getPersonList() {
		return personList;
	}
	
	public void setPersonList(List<PersonClient> personList) {
		this.personList = personList;
	}
	
	
}
