package ar.com.decrypto.challenge.service.market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ar.com.decrypto.challenge.dao.comitent.ComitentDao;
import ar.com.decrypto.challenge.dao.market.MarketDao;
import ar.com.decrypto.challenge.entity.Comitent;
import ar.com.decrypto.challenge.entity.Market;
import ar.com.decrypto.challenge.exception.market.MarketException;
import ar.com.decrypto.challenge.interfaces.market.MarketInterface;
import ar.com.decrypto.challenge.request.comitent.ComitentRequest;
import ar.com.decrypto.challenge.request.market.MarketRequest;
import ar.com.decrypto.challenge.response.market.MarketComitentResponse;

@Service
public class MarketService implements MarketInterface {

	@Autowired
	private MarketDao marketDao;

	@Autowired
	private ComitentDao comitentDao;

	@Override
	public void createMarket(MarketRequest request) throws MarketException {
		Market market = new Market();
		Comitent comitent = comitentDao.findByDescription(request.getComitentDescription());
		final List<Market> marketDuplicate = marketDao.findByCode(request.getCode());

		if (comitent == null) {
			throw new MarketException(HttpStatus.NOT_FOUND, "No existe el comitente!");
		}

		validateCountry(request.getCountry());

		if (!CollectionUtils.isEmpty(marketDuplicate) && marketDuplicate.stream()
				.filter(m -> m.getComitent().getDescription().equalsIgnoreCase(request.getComitentDescription()))
				.count() >= 1) {
			throw new MarketException(HttpStatus.CONFLICT, "Ya existe este codigo de mercado para este comitente!");
		}

		market.setCode(request.getCode());
		market.setCountry(request.getCountry());
		market.setDescription(request.getDescription());

		market.setComitent(comitent);

		marketDao.save(market);
	}

	@Override
	public MarketComitentResponse getMarket(String code) throws MarketException {
		List<Market> listMarket = marketDao.findByCode(code);

		MarketComitentResponse response = new MarketComitentResponse();
		ArrayList<ComitentRequest> listComitent = new ArrayList<>();

		if (CollectionUtils.isEmpty(listMarket)) {
			throw new MarketException(HttpStatus.NOT_FOUND, "No existe ningun mercado con ese codigo!");
		}

		for (Market market : listMarket) {
			response.setCode(code);
			response.setCountry(market.getCountry());
			response.setDescription(market.getDescription());

			ComitentRequest comitentReq = new ComitentRequest();

			comitentReq.setDescription(market.getComitent().getDescription());

			listComitent.add(comitentReq);
		}

		response.setListComitent(listComitent);

		return response;
	}

	@Override
	public void updateMarket(String code, String comitentDescription, MarketRequest request) throws MarketException {
		Market market = marketDao.findByCodeAndComitent(code, comitentDescription);
		Comitent comitent = comitentDao.findByDescription(request.getComitentDescription());

		if (market == null) {
			throw new MarketException(HttpStatus.NOT_FOUND, "No existe el mercado!");
		}

		validateCountry(request.getCountry());

		market.setCode(request.getCode());
		market.setCountry(request.getCountry());
		market.setDescription(request.getDescription());
		market.setComitent(comitent);

		marketDao.save(market);
	}

	@Override
	public void deleteMarket(String code, String comitentDescription) throws MarketException {
		Market market = marketDao.findByCodeAndComitent(code, comitentDescription);

		if (market == null) {
			throw new MarketException(HttpStatus.NOT_FOUND, "No existe el mercado!");
		}

		marketDao.delete(market);
	}

	/**
	 * Valida que el pais ser argentina o uruguay
	 * 
	 * @param country - pais
	 * @throws MarketException
	 */
	private void validateCountry(String country) throws MarketException {
		if (!country.equalsIgnoreCase("argentina") && !country.equalsIgnoreCase("uruguay")) {
			throw new MarketException(HttpStatus.BAD_REQUEST, "El pais debe ser argentina o uruguay!");
		}
	}
}