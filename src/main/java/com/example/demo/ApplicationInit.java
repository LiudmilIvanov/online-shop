 package com.example.demo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.entities.CategoryEntity;
import com.example.demo.model.entities.ProductEntity;
import com.example.demo.model.entities.RoleEntity;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.enums.CategoryTypeEnum;
import com.example.demo.model.enums.RoleTypeEnum;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.OrderService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Component
public class ApplicationInit implements CommandLineRunner{

	private final RoleService roleService;
	private final ProductRepository productRepository;
	private final CategoryService categoryService;
	private final OrderService orderService;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	
	
	@Autowired
	public ApplicationInit(RoleService roleService, ProductRepository productRepository, CategoryService categoryService, 
			OrderService orderService, PasswordEncoder passwordEncoder, UserRepository userRepository, CategoryRepository categoryRepository) {
		this.roleService = roleService;
		this.productRepository = productRepository;
		this.categoryService = categoryService;
		this.orderService = orderService;
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		intRoles();
		initCategories();
		//initFirstUser();
	//	initInitialProducts();
	
	}

	@Transactional
	private void initInitialProducts() {
		ProductEntity productOne = new ProductEntity();
		productOne.setCategory(categoryRepository.findByName(CategoryTypeEnum.TEA))
				  .setDescription("Ginger tea is a non-alcoholic, non-caffeinated, and virtually calorie-free drink")
				  .setName("Ginger Tea")
				  .setPrice(new BigDecimal(1.5))
				  .setImageUrl("https://teahousesofia.com/assets/teas/_51B2997_resized.jpg");
		
		ProductEntity productTwo = new ProductEntity();
		productTwo.setCategory(categoryRepository.findByName(CategoryTypeEnum.TEA))
				  .setDescription("Korean Sencha is unlike any tea I've ever had. It's probably closest in flavor and texture to sencha, but smoother")
				  .setName("Korean Sencha Tea")
				  .setPrice(new BigDecimal(2.5))
				  .setImageUrl("https://teahousesofia.com/assets/teas/_51B3431_resized.jpg");
		
		ProductEntity productThree = new ProductEntity();
		productThree.setCategory(categoryRepository.findByName(CategoryTypeEnum.TEA))
				.setDescription("Gyokuro (Jade Dew) is the most sought after and luxurious type of green tea from Japan")
				.setName("Gyokuro")
				.setPrice(new BigDecimal(1.2))
				.setImageUrl("https://teahousesofia.com/assets/teas/tea_1618925265.jpeg");
		
		ProductEntity productFour = new ProductEntity();
		productFour.setCategory(categoryRepository.findByName(CategoryTypeEnum.COFFEE))
				.setDescription("Coffea arabica, also known as the Arabian coffee, \"coffee shrub of Arabia\", \"mountain coffee\" or \"arabica coffee\", is a species of Coffea.")
				.setName("Arabica")
				.setPrice(new BigDecimal(1.1))
				.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIIhYixrgfMDa5hQNihr20abEnQuy6jOW7IQ&usqp=CAU");
		
		ProductEntity productFive = new ProductEntity();
		productFive.setCategory(categoryRepository.findByName(CategoryTypeEnum.NUTS))
				.setDescription("The cashew nut is the true fruit, and is considered a drupe. The cashew apple can be eaten fresh, cooked in curries, or fermented into vinegar, as well as an alcoholic drink")
				.setName("Cashews")
				.setPrice(new BigDecimal(2.3))
				.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDWenOwpBKMKc9x-dlOmoIvKq1QSCTQtOaDg&usqp=CAU");
		
		productRepository.saveAll(List.of(productFive));
	}


	private void initFirstUser() {
		UserEntity userAdmin = new UserEntity();
		userAdmin.setPassword(passwordEncoder.encode("123"));
		userAdmin.setEmail("admin@abv.bg");
		userRepository.save(userAdmin);
		
	}


	private void initCategories() {
		if (!categoryService.ifCategoryExist()) {
			Arrays.stream(CategoryTypeEnum.values())
				.forEach(categoryName -> {
					CategoryEntity category = new CategoryEntity(categoryName);
					
					categoryService.saveCategories(category);
				});
		}
		
	}



	private void intRoles() {
		if (!roleService.ifRolesExist()) {
			Arrays.stream(RoleTypeEnum.values())
				.forEach(roleName -> {
					RoleEntity role = new RoleEntity(roleName);
					
					roleService.saveRoles(role);
				});
		}
		
	}

	
}
