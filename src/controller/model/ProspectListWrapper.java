package controller.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Prospects")


public class ProspectListWrapper {

	

	


	    private List<Prospect> prospect;

	    @XmlElement(name = "prospect")
	    
	    public List<Prospect> getProspect() 
	    {
	        return prospect;
	    }

	    public void setProspect(List<Prospect> prospect) {
	        this.prospect = prospect;
	    }
	}

