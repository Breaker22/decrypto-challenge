package ar.com.decrypto.challenge.interfaces.comitent;

import ar.com.decrypto.challenge.exception.comitent.ComitentException;
import ar.com.decrypto.challenge.request.comitent.ComitentRequest;
import ar.com.decrypto.challenge.response.comitent.ComitentResponse;

public interface ComitentInterface {

	/**
	 * Crea un comitente
	 * 
	 * @param request - request del comitente
	 * @throws ComitentException
	 */
	public void createComitent(ComitentRequest request) throws ComitentException;

	/**
	 * Obtiene un comitente
	 * 
	 * @param description - descripcion a buscar
	 * @return comitente
	 * @throws ComitentException
	 */
	public ComitentResponse getComitent(String description) throws ComitentException;

	/**
	 * Actualiza un comitente
	 * 
	 * @param description - descripcion a actualizar
	 * @param request     - nuevo request
	 * @throws ComitentException
	 */
	public void updateComitent(String description, ComitentRequest request) throws ComitentException;

	/**
	 * Borra un comitente
	 * 
	 * @param description - descripcion a buscar
	 * @throws ComitentException
	 */
	public void deleteComitent(String description) throws ComitentException;
}
