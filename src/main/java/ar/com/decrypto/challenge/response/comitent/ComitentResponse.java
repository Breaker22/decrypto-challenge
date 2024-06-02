package ar.com.decrypto.challenge.response.comitent;

import java.util.List;

import ar.com.decrypto.challenge.request.comitent.ComitentRequest;
import ar.com.decrypto.challenge.response.market.MarketResponse;

public class ComitentResponse extends ComitentRequest {

	private List<MarketResponse> listMarkets;

	public List<MarketResponse> getListMarkets() {
		return listMarkets;
	}

	public void setListMarkets(List<MarketResponse> listMarkets) {
		this.listMarkets = listMarkets;
	}
}