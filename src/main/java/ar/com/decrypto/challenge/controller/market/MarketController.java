package ar.com.decrypto.challenge.controller.market;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.decrypto.challenge.exception.market.MarketException;
import ar.com.decrypto.challenge.interfaces.market.MarketInterface;
import ar.com.decrypto.challenge.request.market.MarketRequest;
import ar.com.decrypto.challenge.response.ErrorResponse;
import ar.com.decrypto.challenge.response.market.MarketComitentResponse;

@RestController
@RequestMapping(value = "/v1/market")
public class MarketController {

	@Autowired
	private MarketInterface marketInterface;

	@PostMapping
	public ResponseEntity<?> createMarket(@Valid @RequestBody MarketRequest request) throws MarketException {
		marketInterface.createMarket(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<MarketComitentResponse> getMarket(@Valid @RequestParam String code) throws MarketException {
		return ResponseEntity.ok().body(marketInterface.getMarket(code));
	}

	@PutMapping
	public ResponseEntity<?> updateMarket(@Valid @RequestParam String code,
			@Valid @RequestParam(name = "comitent_desc") String comitentDesc, @RequestBody MarketRequest request)
			throws MarketException {
		marketInterface.updateMarket(code, comitentDesc, request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteMarket(@Valid @RequestParam String code,
			@Valid @RequestParam(name = "comitent_desc") String comitentDesc) throws MarketException {
		marketInterface.deleteMarket(code, comitentDesc);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(MarketException.class)
	private ResponseEntity<ErrorResponse> handleExComitent(MarketException ex) {
		ErrorResponse error = new ErrorResponse();

		error.setMessage(ex.getMessage());

		return ResponseEntity.status(ex.getStatus()).body(error);
	}
}
