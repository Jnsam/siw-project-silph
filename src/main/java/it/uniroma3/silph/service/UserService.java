package it.uniroma3.silph.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.silph.model.User;
import it.uniroma3.silph.storage.UserRepository;

@Transactional
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository; 
	
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> findAll() {
		return (List<User>) this.userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user.isPresent()) 
			return user.get();
		else
			return null;
	}
}
