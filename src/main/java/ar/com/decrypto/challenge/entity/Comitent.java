package ar.com.decrypto.challenge.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comitent implements Serializable {
	
	private static final long serialVersionUID = 5766767068512943664L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	@OneToMany(mappedBy = "comitent", cascade = CascadeType.ALL)
	private List<Market> market;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Market> getMarket() {
		return market;
	}

	public void setMarket(List<Market> market) {
		this.market = market;
	}
}