package com.basicauthentication.sample;

import com.basicauthentication.sample.entity.Role;
import com.basicauthentication.sample.entity.User;
import com.basicauthentication.sample.repository.RoleRepository;
import com.basicauthentication.sample.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SampleApplication{

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	public SampleApplication(UserRepository userRepository,
							 RoleRepository roleRepository){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
