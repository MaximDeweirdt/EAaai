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
import consumer.RichPeople;
import consumer.YoungPeople;

public class DataGenConsumer {

	public static void main(String[] args) {
		try{ 
			FileOutputStream file = new FileOutputStream("consumerData.xml", true);
	        JAXBContext jaxbContext = JAXBContext.newInstance(PersonClient.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        
	        List<PersonClient> personeList = new ArrayList<>();
	        Random rand = new Random();
	        for(int i=0;i<10;i++){
	        	int personType = rand.nextInt(4);
	        	PersonClient persone = getPerson(personType);
	        
	            jaxbMarshaller.marshal(persone, file);
	        }

	       } catch (JAXBException e) {
	        e.printStackTrace();
	          } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	}

	private static PersonClient getPerson(int personType) {
		PersonClient person = null;
		switch(personType){
		case 0: person = new YoungPeople();
				break;
		case 1: person = new OldPeople();
				break;
		case 2: person = new GreenPeople();
				break;
		case 3: person = new RichPeople();
				break;
		default : person = null;
				break;
		}
		return person;
	}

}
