package ar.com.decrypto.challenge.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Market implements Serializable {

	private static final long serialVersionUID = 2937938289976323865L;

	@Id
	@GeneratedValue
	private Long id;

	private String code;

	private String description;

	private String country;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id_comitent")
	private Comitent comitent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Comitent getComitent() {
		return comitent;
	}

	public void setComitent(Comitent comitent) {
		this.comitent = comitent;
	}
}