package simulator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;

import consumer.PersonClient;
import order.Order;
import order.OrderList;

import org.w3c.dom.*;

public class Simulath0rMain {

	public static void main(String[] args) {
	    
	    try {
	        //read order data
	    	File fXmlFile = new File("orderData.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
    	    doc.getDocumentElement().normalize();
    	    NodeList nList = doc.getElementsByTagName("order");
	        List<Order> orderList = unmarshalDataOrder(nList);
	        
	    	//read consumer data
	    	fXmlFile = new File("consumerData.xml");
    	    dbFactory = DocumentBuilderFactory.newInstance();
    	    dBuilder = dbFactory.newDocumentBuilder();
    	    doc = dBuilder.parse(fXmlFile);
    	    doc.getDocumentElement().normalize();
	        nList = doc.getElementsByTagName("personClient");
	        List<PersonClient> personList = unmarshalData(nList,orderList);
	        
	        Solution solution = new Solution(orderList,personList);
	        NegotiationProtocol negotiationProtocol = new NegotiationProtocol();
	        negotiationProtocol.negotiate(solution);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	private static List<Order> unmarshalDataOrder(NodeList nList) {
		List<Order> orderList = new ArrayList<>();
		for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                
            	String discountString = eElement.getElementsByTagName("discount").item(0).getTextContent();
            	String takeoutString = eElement.getElementsByTagName("takeout").item(0).getTextContent();
            	String serviceString = eElement.getElementsByTagName("service").item(0).getTextContent();
            	String prepDistanceString = eElement.getElementsByTagName("prepDistance").item(0).getTextContent();
            	String spendMoneyString = eElement.getElementsByTagName("spendMoney").item(0).getTextContent();
            	String slowDeliveryString = eElement.getElementsByTagName("slowDelivery").item(0).getTextContent();
            	String greenString = eElement.getElementsByTagName("green").item(0).getTextContent();
            	String priceString = eElement.getElementsByTagName("price").item(0).getTextContent();
                String XcoordString = eElement.getElementsByTagName("xCoordFirm").item(0).getTextContent();
            	String YcoordString = eElement.getElementsByTagName("yCoordFirm").item(0).getTextContent();
            	
            	double discount = Double.parseDouble(discountString);
            	double takeout = Double.parseDouble(takeoutString);
            	double service = Double.parseDouble(serviceString);
            	double prepDistance = Double.parseDouble(prepDistanceString);
            	double spendMoney = Double.parseDouble(spendMoneyString);
            	double slowDelivery = Double.parseDouble(slowDeliveryString);
            	double green = Double.parseDouble(greenString);
            	double price = Double.parseDouble(priceString);
            	int xcoord = Integer.parseInt(XcoordString);
            	int ycoord = Integer.parseInt(YcoordString);
            	
            	Order order = new Order(discount, takeout, service, prepDistance, spendMoney, slowDelivery, green, price);
            	order.setxCoordFirm(xcoord);
            	order.setyCoordFirm(ycoord);
            	
            	orderList.add(order);
            	
//            	System.out.println(order);
//              System.out.println("budget: " + eElement.getElementsByTagName("budget").item(0).getTextContent());
//              System.out.println("discount : " + eElement.getElementsByTagName("discount").item(0).getTextContent());
//              System.out.println("green : " + eElement.getElementsByTagName("green").item(0).getTextContent());
//              System.out.println("prepDistance : " + eElement.getElementsByTagName("prepDistance").item(0).getTextContent());
//              System.out.println("regio : " + eElement.getElementsByTagName("regio").item(0).getTextContent());
//              System.out.println("service : " + eElement.getElementsByTagName("service").item(0).getTextContent());
//              System.out.println("slowDelivery : " + eElement.getElementsByTagName("slowDelivery").item(0).getTextContent());
//              System.out.println("spendMoney : " + eElement.getElementsByTagName("spendMoney").item(0).getTextContent());
//              System.out.println("takeout : " + eElement.getElementsByTagName("takeout").item(0).getTextContent());
//              System.out.println("xcoord : " + eElement.getElementsByTagName("Xcoord").item(0).getTextContent());
//              System.out.println("ycoord : " + eElement.getElementsByTagName("Ycoord").item(0).getTextContent());
                
            }
		}
		return orderList;
	}

	private static List<PersonClient> unmarshalData(NodeList nList, List<Order> orderList) {
		List<PersonClient> personList = new ArrayList<>();
		for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                
            	String discountString = eElement.getElementsByTagName("discount").item(0).getTextContent();
            	String takeoutString = eElement.getElementsByTagName("takeout").item(0).getTextContent();
            	String serviceString = eElement.getElementsByTagName("service").item(0).getTextContent();
            	String prepDistanceString = eElement.getElementsByTagName("prepDistance").item(0).getTextContent();
            	String spendMoneyString = eElement.getElementsByTagName("spendMoney").item(0).getTextContent();
            	String slowDeliveryString = eElement.getElementsByTagName("slowDelivery").item(0).getTextContent();
            	String greenString = eElement.getElementsByTagName("green").item(0).getTextContent();
            	String budgetString = eElement.getElementsByTagName("budget").item(0).getTextContent();
                String regioString = eElement.getElementsByTagName("regio").item(0).getTextContent();
            	String XcoordString = eElement.getElementsByTagName("Xcoord").item(0).getTextContent();
            	String YcoordString = eElement.getElementsByTagName("Ycoord").item(0).getTextContent();
            	
            	double discount = Double.parseDouble(discountString);
            	double takeout = Double.parseDouble(takeoutString);
            	double service = Double.parseDouble(serviceString);
            	double prepDistance = Double.parseDouble(prepDistanceString);
            	double spendMoney = Double.parseDouble(spendMoneyString);
            	double slowDelivery = Double.parseDouble(slowDeliveryString);
            	double green = Double.parseDouble(greenString);
            	double budget = Double.parseDouble(budgetString);
            	int regio = Integer.parseInt(regioString);
            	int xcoord = Integer.parseInt(XcoordString);
            	int ycoord = Integer.parseInt(YcoordString);
            	
            	PersonClient person = new PersonClient(discount, takeout, service, prepDistance, spendMoney, slowDelivery, green, budget);
            	person.setXcoord(xcoord);
            	person.setYcoord(ycoord);
            	person.setRegio(regio);
            	
            	//add random order to the person
            	Random rand = new Random(0);
            	person.setOrder(orderList.get(rand.nextInt(orderList.size()-1)));            	
            	personList.add(person);
            	
//            	System.out.println(person);
//              System.out.println("budget: " + eElement.getElementsByTagName("budget").item(0).getTextContent());
//              System.out.println("discount : " + eElement.getElementsByTagName("discount").item(0).getTextContent());
//              System.out.println("green : " + eElement.getElementsByTagName("green").item(0).getTextContent());
//              System.out.println("prepDistance : " + eElement.getElementsByTagName("prepDistance").item(0).getTextContent());
//              System.out.println("regio : " + eElement.getElementsByTagName("regio").item(0).getTextContent());
//              System.out.println("service : " + eElement.getElementsByTagName("service").item(0).getTextContent());
//              System.out.println("slowDelivery : " + eElement.getElementsByTagName("slowDelivery").item(0).getTextContent());
//              System.out.println("spendMoney : " + eElement.getElementsByTagName("spendMoney").item(0).getTextContent());
//              System.out.println("takeout : " + eElement.getElementsByTagName("takeout").item(0).getTextContent());
//              System.out.println("xcoord : " + eElement.getElementsByTagName("Xcoord").item(0).getTextContent());
//              System.out.println("ycoord : " + eElement.getElementsByTagName("Ycoord").item(0).getTextContent());
                
            }
		}
		return personList;
	}
}
