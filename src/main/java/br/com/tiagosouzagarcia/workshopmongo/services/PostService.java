package br.com.tiagosouzagarcia.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiagosouzagarcia.workshopmongo.domain.Post;
import br.com.tiagosouzagarcia.workshopmongo.domain.User;
import br.com.tiagosouzagarcia.workshopmongo.repository.PostRepository;
import br.com.tiagosouzagarcia.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
