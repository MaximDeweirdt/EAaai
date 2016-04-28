package consumer;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "personlist")
@XmlAccessorType (XmlAccessType.FIELD)
public class PersonListClient {
	@XmlElement(name = "personClient")
	private List<PersonClient> personList;
	
	public PersonListClient(){}
	
	public PersonListClient(List<PersonClient> pl){
		personList = pl;
	}

	public List<PersonClient> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonClient> personList) {
		this.personList = personList;
	}
	
	
}
