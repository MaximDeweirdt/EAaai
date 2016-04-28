package order;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import consumer.PersonClient;

@XmlRootElement(name = "orderList")
@XmlAccessorType (XmlAccessType.FIELD)
public class OrderList {
	@XmlElement(name = "order")
	private List<Order> orderList;
	
	public OrderList(){}
	
	public OrderList(List<Order> ol){
		orderList = ol;
	}

	public List<Order> getPersonList() {
		return orderList;
	}

	public void setPersonList(List<Order> ol) {
		this.orderList = ol;
	}
}
