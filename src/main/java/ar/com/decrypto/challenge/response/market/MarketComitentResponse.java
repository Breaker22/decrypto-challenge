package ar.com.decrypto.challenge.response.market;

import java.util.List;

import ar.com.decrypto.challenge.request.comitent.ComitentRequest;

public class MarketComitentResponse extends MarketResponse {

	private List<ComitentRequest> listComitent;

	public List<ComitentRequest> getListComitent() {
		return listComitent;
	}

	public void setListComitent(List<ComitentRequest> listComitent) {
		this.listComitent = listComitent;
	}
}