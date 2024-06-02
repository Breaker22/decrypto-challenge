package ar.com.decrypto.challenge.dao.comitent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.decrypto.challenge.entity.Comitent;
import ar.com.decrypto.challenge.repository.comitent.ComitentRepository;

@Service
public class ComitentDao {
	
	@Autowired
	private ComitentRepository comitentRepo;
	
	public Comitent findByDescription(String description) {
		return comitentRepo.findByDescription(description);
	}
	
	public void save(Comitent comitent) {
		comitentRepo.save(comitent);
	}
	
	public void delete(Comitent comitent) {
		comitentRepo.delete(comitent);
	}

}
