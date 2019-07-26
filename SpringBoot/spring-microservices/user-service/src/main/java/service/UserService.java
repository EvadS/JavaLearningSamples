package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.User;

@Service
public class UserService {

	@Autowired
	private EmailService emailService;

	private final List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		users.add(new User(1000, "Soumitra", "Roy", "contact@jeejava.com"));
		users.add(new User(1001, "Sudipto", "Bhowmick", "sudipto.bhowmick@email.com"));
		users.add(new User(1002, "Gautam", "Roy", "gautam.roy@email.com"));
		users.add(new User(1003, "Soumitra", "Sarkar", "contact@jeejava.com"));
	}

	public User getUserById(final int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	public void sendEmail(User user) {
		emailService.sendEmail(user.getEmail());
	}
}
