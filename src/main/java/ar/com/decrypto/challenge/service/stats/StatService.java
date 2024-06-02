package ar.com.decrypto.challenge.service.stats;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.decrypto.challenge.dao.market.MarketDao;
import ar.com.decrypto.challenge.entity.Market;
import ar.com.decrypto.challenge.interfaces.stats.StatInterface;
import ar.com.decrypto.challenge.response.stats.StatMarketResponse;
import ar.com.decrypto.challenge.response.stats.StatResponse;

@Service
public class StatService implements StatInterface {

	@Autowired
	private MarketDao marketDao;

	@Override
	public List<StatResponse> getStats() {
		Map<String, List<Market>> mapMarket = marketDao.findAll().stream()
				.collect(Collectors.groupingBy(Market::getCountry));

		ArrayList<StatResponse> listResponse = new ArrayList<>();

		for (Entry<String, List<Market>> entryMarket : mapMarket.entrySet()) {
			List<StatMarketResponse> listStatsMarket = new ArrayList<>();

			Map<String, List<Market>> mapMkCode = entryMarket.getValue().stream()
					.collect(Collectors.groupingBy(Market::getCode));

			StatResponse response = new StatResponse();

			for (Entry<String, List<Market>> entryMkCode : mapMkCode.entrySet()) {
				StatMarketResponse statsMarket = new StatMarketResponse();
				BigDecimal auxMultiply = new BigDecimal("100");

				statsMarket.setCode(entryMkCode.getKey());
				statsMarket.setPercentage(auxMultiply.divide(new BigDecimal(mapMkCode.size()), 2, RoundingMode.HALF_UP).toString());

				listStatsMarket.add(statsMarket);
			}

			response.setCountry(entryMarket.getKey());
			response.setMarket(listStatsMarket);
			listResponse.add(response);
		}

		return listResponse;
	}
}