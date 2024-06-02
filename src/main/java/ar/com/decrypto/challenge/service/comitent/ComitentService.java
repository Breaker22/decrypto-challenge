package ar.com.decrypto.challenge.service.comitent;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import ar.com.decrypto.challenge.dao.comitent.ComitentDao;
import ar.com.decrypto.challenge.entity.Comitent;
import ar.com.decrypto.challenge.entity.Market;
import ar.com.decrypto.challenge.exception.comitent.ComitentException;
import ar.com.decrypto.challenge.interfaces.comitent.ComitentInterface;
import ar.com.decrypto.challenge.request.comitent.ComitentRequest;
import ar.com.decrypto.challenge.response.comitent.ComitentResponse;
import ar.com.decrypto.challenge.response.market.MarketResponse;

@Service
public class ComitentService implements ComitentInterface {

	@Autowired
	private ComitentDao comitentDao;

	@Override
	public void createComitent(ComitentRequest request) throws ComitentException {
		Comitent comitent = new Comitent();

		if (comitentDao.findByDescription(request.getDescription()) != null) {
			throw new ComitentException(HttpStatus.CONFLICT, "Ya existe este comitente!");
		}

		comitent.setDescription(request.getDescription());

		comitentDao.save(comitent);
	}

	@Override
	public ComitentResponse getComitent(String description) throws ComitentException {
		Comitent comitent = comitentDao.findByDescription(description);

		if (comitent == null) {
			throw new ComitentException(HttpStatus.NOT_FOUND, "No existe este comitente!");
		}

		ComitentResponse response = new ComitentResponse();
		ArrayList<MarketResponse> listMarketRes = new ArrayList<>();

		response.setDescription(description);

		for (Market market : comitent.getMarket()) {
			MarketResponse marketRes = new MarketResponse();

			marketRes.setCode(market.getCode());
			marketRes.setCountry(market.getCountry());
			marketRes.setDescription(market.getDescription());

			listMarketRes.add(marketRes);
		}

		response.setListMarkets(listMarketRes);

		return response;
	}

	@Override
	public void updateComitent(String description, ComitentRequest request) throws ComitentException {
		Comitent comitent = comitentDao.findByDescription(description);

		if (comitent == null) {
			throw new ComitentException(HttpStatus.NOT_FOUND, "No existe este comitente!");
		}

		comitent.setDescription(request.getDescription());

		comitentDao.save(comitent);
	}

	@Override
	public void deleteComitent(String description) throws ComitentException {
		Comitent comitent = comitentDao.findByDescription(description);
		
		if (comitent == null) {
			throw new ComitentException(HttpStatus.NOT_FOUND, "No existe este comitente!");
		}

		comitentDao.delete(comitent);
	}
}