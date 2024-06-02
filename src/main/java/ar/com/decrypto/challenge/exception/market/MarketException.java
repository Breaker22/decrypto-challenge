package ar.com.decrypto.challenge.exception.market;

import org.springframework.http.HttpStatus;

public class MarketException extends Exception {

	private static final long serialVersionUID = 4980451874941966705L;
	
	private HttpStatus httpStatus;

	public MarketException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
	public HttpStatus getStatus() {
		return this.httpStatus;
	}
}
