package ar.com.decrypto.challenge.response.stats;

import java.util.List;

public class StatResponse {
	
	private String country;
	
	private List<StatMarketResponse> market;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<StatMarketResponse> getMarket() {
		return market;
	}

	public void setMarket(List<StatMarketResponse> market) {
		this.market = market;
	}
}