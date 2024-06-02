package ar.com.decrypto.challenge.dao.market;

import java.util.List;

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
	
	public List<Market> findByCode(Long code) {
		return marketRepo.findByCode(code);
	}
	
	public Market findByCodeAndComitent(Long code, String comitentDesc) {
		return marketRepo.findByCodeAndComitent_Description(code, comitentDesc);
	}
	
	public void delete(Market market) {
		marketRepo.delete(market);
	}
}
