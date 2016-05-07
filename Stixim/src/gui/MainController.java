package gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import consumer.PersonClient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import order.Order;
import simulator.NegotiationProtocol;
import simulator.Solution;

public class MainController implements Initializable {

	@FXML
	private Button generateButton;
	@FXML
	private Button clearButton;

	@FXML
	private Slider takeoutSlider;
	@FXML
	private Slider greenSlider;
	@FXML
	private Slider discountSlider;
	@FXML
	private Slider spendSlider;
	@FXML
	private Slider distanceSlider;

	@FXML
	private TextArea dataTextArea;

	@FXML
	private Label distanceLabel;
	@FXML
	private Label greenLabel;
	@FXML
	private Label takeLabel;
	@FXML
	private Label spendLabel;
	@FXML
	private Label discountLabel;

	Group root;

	int count1 = 0;
	boolean drawShape1 = true;
	Solution solution;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			// read order data
			File fXmlFile = new File("orderData.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("order");
			List<Order> orderList = unmarshalDataOrder(nList);

			// read consumer data
			fXmlFile = new File("consumerData.xml");
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName("personClient");
			List<PersonClient> personList = unmarshalData(nList, orderList);

			solution = new Solution(orderList, personList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onGenerateClickEvent() {
		generateButton.setText("Generating...");
		System.out.println("generating");

		double greenValue = greenSlider.getValue();
		double takeoutValue = takeoutSlider.getValue();
		double discountValue = discountSlider.getValue();
		double distanceValue = distanceSlider.getValue();
		double spendValue = spendSlider.getValue();

		solution.updateValuesPersons(greenValue, takeoutValue, discountValue, distanceValue, spendValue);

		NegotiationProtocol negotiationProtocol = new NegotiationProtocol();
		negotiationProtocol.negotiate(solution);

		printValues();

		generateButton.setText("Generate");
	}

	public void onClearClickEvent() {

		dataTextArea.clear();
		
		spendSlider.setValue(0);
		greenSlider.setValue(0);
		distanceSlider.setValue(0);
		discountSlider.setValue(0);
		takeoutSlider.setValue(0);
		
		spendLabel.setText("0");
		greenLabel.setText("0");
		distanceLabel.setText("0");
		takeLabel.setText("0");
		discountLabel.setText("0");
		
	}

	public void onSpendChangeEvent() {
		spendLabel.setText(""+ Math.round(spendSlider.getValue()*100)/100.0);
	}

	public void onGreenChangeEvent() {
		greenLabel.setText(""+ Math.round(greenSlider.getValue()*100)/100.0);
	}

	public void onTakeChangeEvent() {
		takeLabel.setText(""+ Math.round(takeoutSlider.getValue()*100)/100.0);
	}

	public void onDiscChangeEvent() {
		discountLabel.setText(""+ Math.round(discountSlider.getValue()*100)/100.0);
	}

	public void onDistChangeEvent() {
		distanceLabel.setText(""+ Math.round(distanceSlider.getValue()*100)/100.0);
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
				String classString = eElement.getElementsByTagName("peopleClasee").item(0).getTextContent();

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

				PersonClient person = new PersonClient(discount, takeout, service, prepDistance, spendMoney,
						slowDelivery, green, budget);
				person.setPeopleClasee(classString);
				person.setXcoord(xcoord);
				person.setYcoord(ycoord);
				person.setRegio(regio);

				// add random order to the person
				Random rand = new Random(0);
				person.setOrder(orderList.get(rand.nextInt(orderList.size() - 1)));
				personList.add(person);

			}
		}
		return personList;
	}

	private void printValues() {

		Map<Integer, List<PersonClient>> personMap = solution.getPersonMap();
		for (Map.Entry<Integer, List<PersonClient>> entry : personMap.entrySet()) {
			Integer key = entry.getKey();
			List<PersonClient> personList = entry.getValue();
			double takeOutAmount = 0;
			double slowDelivery = 0;
			double notAcceptedOrder = 0;
			double normalDelivery = 0;
			int amountOfGreenPeople = 0;
			int amountOfYoungPeople = 0;
			int amountOfOldPeople = 0;
			int amountOfRichPeople = 0;
			for (PersonClient person : personList) {
				if (!person.isAcceptOrder())
					notAcceptedOrder++;
				if (person.isLateDelivery())
					slowDelivery++;
				if (person.isTakeoutBoolean())
					takeOutAmount++;
				if (person.isDeliveryAtHome())
					normalDelivery++;
				if (person.getPeopleClasee().equals("green"))
					amountOfGreenPeople++;
				if (person.getPeopleClasee().equals("young"))
					amountOfYoungPeople++;
				if (person.getPeopleClasee().equals("old"))
					amountOfOldPeople++;
				if (person.getPeopleClasee().equals("rich"))
					amountOfRichPeople++;
			}
			dataTextArea.appendText("Gebied " + key + " gegevens\n");
			dataTextArea.appendText("aantal afhalen = " + takeOutAmount + "\n");
			dataTextArea.appendText("aantal vertraagd leveren = " + slowDelivery + "\n");
			dataTextArea.appendText("aantal normale levering = " + normalDelivery + "\n");
			dataTextArea.appendText("aantal niet geaccepteerde bestellingen = " + notAcceptedOrder + "\n");

			dataTextArea.appendText("Gegevens over personen in het gebied\n");
			dataTextArea.appendText("aantal groene mensen = " + amountOfGreenPeople + "\n");
			dataTextArea.appendText("aantal jonge mensen = " + amountOfYoungPeople + "\n");
			dataTextArea.appendText("aantal oude mensen = " + amountOfOldPeople + "\n");
			dataTextArea.appendText("aantal rijke mensen = " + amountOfRichPeople + "\n");
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

				Order order = new Order(discount, takeout, service, prepDistance, spendMoney, slowDelivery, green,
						price);
				order.setxCoordFirm(xcoord);
				order.setyCoordFirm(ycoord);

				orderList.add(order);

				// System.out.println(order);
				// System.out.println("budget: " +
				// eElement.getElementsByTagName("budget").item(0).getTextContent());
				// System.out.println("discount : " +
				// eElement.getElementsByTagName("discount").item(0).getTextContent());
				// System.out.println("green : " +
				// eElement.getElementsByTagName("green").item(0).getTextContent());
				// System.out.println("prepDistance : " +
				// eElement.getElementsByTagName("prepDistance").item(0).getTextContent());
				// System.out.println("regio : " +
				// eElement.getElementsByTagName("regio").item(0).getTextContent());
				// System.out.println("service : " +
				// eElement.getElementsByTagName("service").item(0).getTextContent());
				// System.out.println("slowDelivery : " +
				// eElement.getElementsByTagName("slowDelivery").item(0).getTextContent());
				// System.out.println("spendMoney : " +
				// eElement.getElementsByTagName("spendMoney").item(0).getTextContent());
				// System.out.println("takeout : " +
				// eElement.getElementsByTagName("takeout").item(0).getTextContent());
				// System.out.println("xcoord : " +
				// eElement.getElementsByTagName("Xcoord").item(0).getTextContent());
				// System.out.println("ycoord : " +
				// eElement.getElementsByTagName("Ycoord").item(0).getTextContent());

			}
		}
		return orderList;
	}

}
