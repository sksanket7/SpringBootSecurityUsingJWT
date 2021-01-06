package com.sanket.SpringBootSecurityUsingJWT;

import com.sanket.SpringBootSecurityUsingJWT.entity.User;
import com.sanket.SpringBootSecurityUsingJWT.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootSecurityUsingJwtApplication {

	@Autowired
	private UserRepositoy userRepositoy;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(101,"sanket","password","sanket@gmail.com"),
				new User(102,"anand","password","anand@gmail.com"),
				new User(103,"jagjit","password","jagjit@gmail.com"),
				new User(104,"vandana","password","vandana@gmail.com")
				).collect(Collectors.toList());
		userRepositoy.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityUsingJwtApplication.class, args);
	}

}
