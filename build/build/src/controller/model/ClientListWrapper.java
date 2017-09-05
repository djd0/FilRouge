package controller.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Clients")

public class ClientListWrapper {
	
	

	    private List<Client> clients;

	    @XmlElement(name = "client")
	    
	    public List<Client> getClient() 
	    {
	        return clients;
	    }

	    public void setClient(List<Client> clients) {
	        this.clients = clients;
	    }
	}
