package simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import consumer.PersonClient;
import order.Order;

public class Solution {
	List<Order> orderList;
	List<PersonClient> personList;
	Map<Integer,List<PersonClient>> personMap;
		
	public Solution(List<Order> orderList, List<PersonClient> personList) {
		super();
		this.orderList = orderList;
		this.personList = personList;
		personMap = new HashMap<>();
		personMap.put(0, new ArrayList<>());
		personMap.put(1, new ArrayList<>());
		personMap.put(2, new ArrayList<>());
		personMap.put(3, new ArrayList<>());
		for(PersonClient personClient:personList){
			if(personClient.getRegio() == 0){
				personMap.get(0).add(personClient);
			}else if(personClient.getRegio() == 1){
				personMap.get(1).add(personClient);
			}else if(personClient.getRegio() == 2){
				personMap.get(2).add(personClient);
			}else if(personClient.getRegio() == 3){
				personMap.get(3).add(personClient);
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

	public Map<Integer, List<PersonClient>> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<Integer, List<PersonClient>> personMap) {
		this.personMap = personMap;
	}
	
	
	
	
}
