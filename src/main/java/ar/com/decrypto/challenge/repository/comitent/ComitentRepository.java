package ar.com.decrypto.challenge.repository.comitent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.decrypto.challenge.entity.Comitent;

@Repository
public interface ComitentRepository extends CrudRepository<Comitent, Long> {

	public Comitent findByDescription(String description);
}
