package com.course.course.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.course.course.entities.Category;
import com.course.course.entities.Order;
import com.course.course.entities.Product;
import com.course.course.entities.User;
import com.course.course.entities.enums.OrderStatus;
import com.course.course.repositories.CategoryRepository;
import com.course.course.repositories.OrderRepository;
import com.course.course.repositories.ProductRepository;
import com.course.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

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

		Category cat1 = new Category("Electronics");
		Category cat2 = new Category("Books");
		Category cat3 = new Category("Computers");

		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.",
				new BigDecimal("90.5"), "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new BigDecimal("2190.0"), "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new BigDecimal("1250.0"),
				"");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal("1200.0"), "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.",
				new BigDecimal("100.99"), "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Order o1 = new Order(null, Instant.parse("2021-10-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-09-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
