package ar.com.decrypto.challenge.controller.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.decrypto.challenge.interfaces.stats.StatInterface;
import ar.com.decrypto.challenge.response.stats.StatResponse;

@RestController
@RequestMapping(value = "/v1/stats")
public class StatController {
	
	@Autowired
	private StatInterface statsInterface;

	@GetMapping
	public ResponseEntity<List<StatResponse>> getStats() {
		return ResponseEntity.ok().body(statsInterface.getStats());
	}

}
