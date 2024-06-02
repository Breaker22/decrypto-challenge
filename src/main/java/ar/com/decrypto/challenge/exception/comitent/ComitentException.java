package ar.com.decrypto.challenge.exception.comitent;

import org.springframework.http.HttpStatus;

public class ComitentException extends Exception {

	private static final long serialVersionUID = -943362115113967060L;
	
	private HttpStatus httpStatus;
	
	public ComitentException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
	public HttpStatus getStatus() {
		return this.httpStatus;
	}

}
