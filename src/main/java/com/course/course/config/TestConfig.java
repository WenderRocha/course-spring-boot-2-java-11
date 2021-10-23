package com.course.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.Order;
import com.course.course.entities.User;
import com.course.course.entities.enums.OrderStatus;
import com.course.course.repositories.OrderRepository;
import com.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User("claudio bernardo lorenzoda silva", "claudiobernardolorenzodasilva_@sdrifs.com.br",
				"(16) 98605-9884", "9bYZ9JXsl5");

		User u2 = new User("Fabiana Carolina Flávia Porto", "ffabianacarolinaflaviaporto@isbt.com.br",
				"(51) 99793-0622", "cQCbaoLa9S");

		User u3 = new User("Guilherme Anderson Marcos dos Santos", "guilhermeandersonmarcosdossantos_@anfip.org.br",
				"(77) 98906-1888", "6MJ4yh2wQp");

		User u4 = new User("Yago Mário Benjamin Porto", "yagomariobenjaminporto_@digitalsj.com.br", "(65) 98556-8234",
				"Unc27ioXUY");

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

		Order o1 = new Order(null, Instant.parse("2021-10-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-09-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
