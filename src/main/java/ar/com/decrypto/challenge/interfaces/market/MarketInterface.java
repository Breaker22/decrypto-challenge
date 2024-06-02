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
	 * @param code - codigo de mercado
	 * @return el mercado con los comitentes
	 * @throws MarketException
	 */
	public MarketComitentResponse getMarket(Long code) throws MarketException;

	/**
	 * Actualiza el mercado
	 * 
	 * @param code                - codigo de mercado
	 * @param comitentDescription - descripcion del comitente
	 * @param request             - request del mercado
	 * @throws MarketException
	 */
	public void updateMarket(Long code, String comitentDescription, MarketRequest request) throws MarketException;

	/**
	 * Elimina el mercado
	 * 
	 * @param code                - codigo de mercado
	 * @param comitentDescription - descripcion del comitente
	 * @throws MarketException
	 */
	public void deleteMarket(Long code, String comitentDescription) throws MarketException;
}
