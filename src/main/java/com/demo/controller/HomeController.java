package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.first.entity.UserInfo;
import com.demo.first.service.UserService;
import com.demo.second.entity.ProductInfo;
import com.demo.second.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping(value = "/user")
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	
	// Exception handling
	@GetMapping("{userid}")
	public UserInfo getUserInfo(@PathVariable("userid") int userid) {
		System.out.println(userid);
		return userService.findUserById(userid);

	}

	@GetMapping
	public List<UserInfo> getall(){
		
		return userService.getUser();	
	}

	@PostMapping
	public String insert(@Valid @RequestBody UserInfo userInfo) {
		userService.createUser(userInfo);
		return "Insert Successfully";
	}

	@PutMapping
	public String update(@Valid @RequestBody UserInfo userInfo) {
		userService.updateUser(userInfo);
		return "update Successfully";
	}

	@DeleteMapping
	public String delete(@Valid @RequestBody UserInfo userInfo) {
		userService.deleteUser(userInfo);
		return "Delete Successfully";
	}

	//h2 database for product  
	@GetMapping("/get")
	public List<ProductInfo> getal(){	 
		return productService.getUser();
	}
	

	@PostMapping("/add")   
	public String add(@Valid @RequestBody ProductInfo productInfo) {
		productService.createProduct(productInfo);
		return "Insert Successfully in H2";
	}

	
	@PutMapping("/upgrade")
	public String upgrade(@Valid @RequestBody ProductInfo productInfo) {
		productService.updateProduct(productInfo);
		return "Upgarde Successfully in H2";	
	}
	
	
	@DeleteMapping("/remove")
	public String Remove(@Valid @RequestBody ProductInfo productInfo) {
		productService.deleteProduct(productInfo);
		return "Remove Successfully in H2";	
	}

}
