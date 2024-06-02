package ar.com.decrypto.challenge.interfaces.market;

import ar.com.decrypto.challenge.exception.market.MarketException;
import ar.com.decrypto.challenge.request.market.MarketRequest;
import ar.com.decrypto.challenge.response.market.MarketComitentResponse;

public interface MarketInterface {

	/**
	 * Crea el mercado
	 * 
	 * @param request - request del mercado
	 * @throws MarketException
	 */
	public void createMarket(MarketRequest request) throws MarketException;

	/**
	 * Obtiene el mercado con los comitentes
	 * 
	 * @param country - pais
	 * @return el mercado con los comitentes
	 * @throws MarketException
	 */
	public MarketComitentResponse getMarket(String country) throws MarketException;

	/**
	 * Actualiza el mercado
	 * 
	 * @param code                - codigo de mercado
	 * @param country             - pais del mercado
	 * @param comitentDescription - descripcion del comitente
	 * @param request             - request del mercado
	 * @throws MarketException
	 */
	public void updateMarket(String code, String country, String comitentDescription, MarketRequest request)
			throws MarketException;

	/**
	 * Elimina el mercado
	 * 
	 * @param code                - codigo de mercado
	 * @param country             - pais del mercado
	 * @param comitentDescription - descripcion del comitente
	 * @throws MarketException
	 */
	public void deleteMarket(String code, String country, String comitentDescription) throws MarketException;
}
