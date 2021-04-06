package br.com.tiagosouzagarcia.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiagosouzagarcia.workshopmongo.domain.User;
import br.com.tiagosouzagarcia.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
}
