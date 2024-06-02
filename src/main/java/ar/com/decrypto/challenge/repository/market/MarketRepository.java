package ar.com.decrypto.challenge.repository.market;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.decrypto.challenge.entity.Market;

@Repository
public interface MarketRepository extends CrudRepository<Market, Long> {

	public List<Market> findByCode(Long code);

	public Market findByCodeAndComitent_Description(Long code, String comitentDesc);
}
