package ar.com.decrypto.challenge.request.market;

public class MarketRequest {

	private Long code;

	private String description;

	private String country;
	
	private String comitentDescription;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
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

	public String getComitentDescription() {
		return comitentDescription;
	}

	public void setComitentDescription(String comitentDescription) {
		this.comitentDescription = comitentDescription;
	}
}
