package data.generator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import consumer.PersonClient;
import consumer.PersonListClient;
import order.Order;
import order.OrderList;

public class DataGenOrder {
	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("orderData.xml", true);
			JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			List<Order> orderList = new ArrayList<>();
			Random rand = new Random();
			for (int i = 0; i < 10; i++) {
				Order order = new Order();
				generateData(order, rand);
				System.out.println(order);
				orderList.add(order);
			}

			// Marshal the employees list in file
			OrderList olList = new OrderList(orderList);

			// Marshal the employees list in console
			jaxbMarshaller.marshal(olList, System.out);

			jaxbMarshaller.marshal(olList, file);
		} catch (

		JAXBException e)

		{
			e.printStackTrace();
		} catch (

		IOException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static void generateData(Order order, Random rand) {
		int value = rand.nextInt(10);
		double discount = (double)(value)/10;
		double discountTakeout = (double)(rand.nextInt(10)) / 10;
		double service = (double)(rand.nextInt(10)) / 10;
		double prepDistance = (double)(rand.nextInt(10)) / 10;
		double spendMoney = (double)(rand.nextInt(10)) / 10;
		double slowDelivery = (double)(rand.nextInt(10)) / 10;
		double green = (double)(rand.nextInt(10)) / 10;
		double price = (double)(rand.nextInt(10000));
		order.setData(discount, discountTakeout, service, prepDistance, spendMoney,
				slowDelivery, green, price);

		int Xcoord = rand.nextInt(2);
		int Ycoord = rand.nextInt(2);

		order.setxCoordFirm(Xcoord*50 + 25);
		order.setyCoordFirm(Ycoord*50 + 25);
	}

}
