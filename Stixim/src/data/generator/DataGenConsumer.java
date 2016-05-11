package data.generator;

import java.util.List;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import consumer.GreenPeople;
import consumer.OldPeople;
import consumer.PersonClient;
import consumer.PersonListClient;
import consumer.RichPeople;
import consumer.YoungPeople;

public class DataGenConsumer {
	private static Random rand;
	
	public static void main(String[] args) {
		try{ 
			FileOutputStream file = new FileOutputStream("consumerData.xml", true);
	        JAXBContext jaxbContext = JAXBContext.newInstance(PersonListClient.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        List<PersonClient> personList = new ArrayList<>();
	        rand = new Random();
	        for(int i=0;i<10000;i++){
	        	int personType = rand.nextInt(4);
	        	PersonClient person = getPerson(personType);
	        	generateData(person);
	        	personList.add(person);
	        }
	        
	        //Marshal the employees list in file
	        PersonListClient plList = new PersonListClient(personList);
	        
	        //Marshal the employees list in console
	       //jaxbMarshaller.marshal(plList, System.out);
	         

	        jaxbMarshaller.marshal(plList,file);
	       } catch (JAXBException e) {
	        e.printStackTrace();
	          } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	}

	private static void generateData(PersonClient person) {
		double discountOffset = rand.nextInt(10)/10;
		double discountTakeoutOffset = rand.nextInt(10)/10;
		double serviceOffset = rand.nextInt(10)/10;
		double prepDistanceOffset = rand.nextInt(10)/10;
		double spendMoneyOffset = rand.nextInt(10)/10;
		double slowDeliveryOffset = rand.nextInt(10)/10;
		double greenOffset = rand.nextInt(10)/10;
		double budgetStartValue = person.getBudgetStartValue();
		double budgetEndValue = person.getBudgetEndValue();
		int budgetDiff = (int) (budgetEndValue - budgetStartValue);
		//System.out.println(person.getClass());
		int budgetOffset = rand.nextInt(budgetDiff);
		person.setData(discountOffset, discountTakeoutOffset, serviceOffset, prepDistanceOffset, spendMoneyOffset, slowDeliveryOffset, greenOffset, budgetOffset);
		

	}

	private static PersonClient getPerson(int personType) {
		PersonClient person = null;
		switch(personType){
		case 0: person = new YoungPeople();
				person.setPeopleClasee("young");
				int Xcoord = rand.nextInt(100);
				int Ycoord = rand.nextInt(100);
				int regio = 0;
				if(Xcoord <= 50){
					if(Ycoord <= 50) regio = 0;
					else regio = 2;
				}else{
					if(Ycoord <= 50) regio = 1;
					else regio = 3;
				}
				person.setXcoord(Xcoord);
				person.setYcoord(Ycoord);
				person.setRegio(regio);
				break;
		case 1: person = new OldPeople();
				person.setPeopleClasee("old");
				Xcoord = rand.nextInt(100);
				Ycoord = rand.nextInt(100);
				regio = 0;
				if(Xcoord <= 50){
					if(Ycoord <= 50) regio = 0;
					else regio = 2;
				}else{
					if(Ycoord <= 50) regio = 1;
					else regio = 3;
				}
				person.setXcoord(Xcoord);
				person.setYcoord(Ycoord);
				person.setRegio(regio);
				break;
		case 2: person = new GreenPeople();
				person.setPeopleClasee("green");
				Xcoord = rand.nextInt(75);
				Ycoord = rand.nextInt(75);
				regio = 0;
				if(Xcoord <= 50){
					if(Ycoord <= 50) regio = 0;
					else regio = 2;
				}else{
					if(Ycoord <= 50) regio = 1;
					else regio = 3;
				}
				person.setXcoord(Xcoord);
				person.setYcoord(Ycoord);
				person.setRegio(regio);
				break;
		case 3: person = new RichPeople();
				person.setPeopleClasee("rich");
				Xcoord = rand.nextInt(75) + 25;
				Ycoord = rand.nextInt(75) + 25;
				regio = 0;
				if(Xcoord <= 50){
					if(Ycoord <= 50) regio = 0;
					else regio = 2;
				}else{
					if(Ycoord <= 50) regio = 1;
					else regio = 3;
				}
				person.setXcoord(Xcoord);
				person.setYcoord(Ycoord);
				person.setRegio(regio);
				break;
		default : person = null;
				break;
		}
		return person;
	}

}
