package simulator;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class Simulath0rMain {

	public static void main(String[] args) {
	    
	    try {
	    	 File fXmlFile = new File("consumerData.xml");
    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	    Document doc = dBuilder.parse(fXmlFile);

    	    //optional, but recommended
    	    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    	    doc.getDocumentElement().normalize();
	
	        NodeList nList = doc.getElementsByTagName("personClient");
	        for (int temp = 0; temp < nList.getLength(); temp++) {

	            Node nNode = nList.item(temp);

	            System.out.println("\nCurrent Element :" + nNode.getNodeName());

	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	                Element eElement = (Element) nNode;

	                System.out.println("budget: " + eElement.getAttribute("budget"));
	                System.out.println("discount : " + eElement.getAttribute("discount"));
	                System.out.println("green : " + eElement.getAttribute("green"));
	                System.out.println("prepDistance : " + eElement.getAttribute("prepDistance"));
	                System.out.println("regio : " + eElement.getAttribute("regio"));
	                System.out.println("service : " + eElement.getAttribute("service"));
	                System.out.println("slowDelivery : " + eElement.getAttribute("slowDelivery"));
	                System.out.println("spendMoney : " + eElement.getAttribute("spendMoney"));
	                System.out.println("takeout : " + eElement.getAttribute("takeout"));
	                System.out.println("xcoord : " + eElement.getAttribute("xcoord"));
	                System.out.println("ycoord : " + eElement.getAttribute("ycoord"));
	            }
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
