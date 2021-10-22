package com.course.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.User;
import com.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = User.builder().id(null).name("claudio bernardo lorenzoda silva")
				.email("claudiobernardolorenzodasilva_@sdrifs.com.br").phone("(16) 98605-9884").password("9bYZ9JXsl5")
				.build();

		User u2 = User.builder().id(null).name("Fabiana Carolina Flávia Porto")
				.email("ffabianacarolinaflaviaporto@isbt.com.br").phone("(51) 99793-0622").password("cQCbaoLa9S")
				.build();

		User u3 = User.builder().id(null).name("Guilherme Anderson Marcos dos Santos")
				.email("guilhermeandersonmarcosdossantos_@anfip.org.br").phone("(77) 98906-1888").password("6MJ4yh2wQp")
				.build();

		User u4 = User.builder().id(null).name("Yago Mário Benjamin Porto")
				.email("yagomariobenjaminporto_@digitalsj.com.br").phone("(65) 98556-8234").password("Unc27ioXUY")
				.build();

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

	}

}
