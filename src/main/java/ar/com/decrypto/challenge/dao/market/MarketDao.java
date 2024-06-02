package ar.com.decrypto.challenge.dao.market;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.decrypto.challenge.entity.Market;
import ar.com.decrypto.challenge.repository.market.MarketRepository;

@Service
public class MarketDao {

	@Autowired
	private MarketRepository marketRepo;

	public void save(Market market) {
		marketRepo.save(market);
	}

	public List<Market> findByCountry(String country) {
		return marketRepo.findByCountry(country);
	}

	public Market findByCodeAndCountryAndComitent(String code, String country, String comitentDesc) {
		return marketRepo.findByCodeAndCountryAndComitent_Description(code, country, comitentDesc);
	}

	public List<Market> findAll() {
		return StreamSupport.stream(marketRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public void delete(Market market) {
		marketRepo.delete(market);
	}
}
