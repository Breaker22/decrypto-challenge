package ar.com.decrypto.challenge.controller.comitent;

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

import ar.com.decrypto.challenge.exception.comitent.ComitentException;
import ar.com.decrypto.challenge.interfaces.comitent.ComitentInterface;
import ar.com.decrypto.challenge.request.comitent.ComitentRequest;
import ar.com.decrypto.challenge.response.ErrorResponse;
import ar.com.decrypto.challenge.response.comitent.ComitentResponse;

@RestController
@RequestMapping(value = "/v1/comitent")
public class ComitentController {

	@Autowired
	private ComitentInterface comitentInterface;

	@PostMapping
	public ResponseEntity<?> createComitent(@Valid @RequestBody ComitentRequest request) throws ComitentException {
		comitentInterface.createComitent(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<ComitentResponse> getComitent(@Valid @RequestParam String description)
			throws ComitentException {
		return ResponseEntity.ok().body(comitentInterface.getComitent(description));
	}

	@PutMapping
	public ResponseEntity<?> updateComitent(@Valid @RequestParam String description,
			@Valid @RequestBody ComitentRequest request) throws ComitentException {
		comitentInterface.updateComitent(description, request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteComitent(@Valid @RequestParam String description) throws ComitentException {
		comitentInterface.deleteComitent(description);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(ComitentException.class)
	private ResponseEntity<ErrorResponse> handleExComitent(ComitentException ex) {
		ErrorResponse error = new ErrorResponse();

		error.setMessage(ex.getMessage());

		return ResponseEntity.status(ex.getStatus()).body(error);
	}
}
