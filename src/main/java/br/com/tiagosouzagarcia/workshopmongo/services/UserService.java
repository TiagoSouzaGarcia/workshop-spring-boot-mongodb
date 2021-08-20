package br.com.tiagosouzagarcia.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiagosouzagarcia.workshopmongo.domain.User;
import br.com.tiagosouzagarcia.workshopmongo.dto.UserDTO;
import br.com.tiagosouzagarcia.workshopmongo.repository.UserRepository;
import br.com.tiagosouzagarcia.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional <User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não econtrado"));
	}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
