package controller.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Representant")

public class RepresentantListWrapper {
	

	
	    private List<Representant> representant;
	
	    @XmlElement(name = "representant")
	    
	    public List<Representant> getRepresentant() 
	    {
	        return representant;
	    }
	
	    public void setRepresentant(List<Representant> representant) {
	        this.representant = representant;
	    }
	}

