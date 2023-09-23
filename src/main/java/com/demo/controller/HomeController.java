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
import org.springframework.web.bind.annotation.RestController;

import com.demo.first.Dao.UserRepository;
import com.demo.first.entity.UserInfo;
import com.demo.first.service.UserService;
import com.demo.second.Dao.ProductRepository;
import com.demo.second.entity.ProductInfo;

@Controller
@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	 
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getall")
	public List<UserInfo> getall(){
		List<UserInfo> userlist = (List<UserInfo>) userRepository.findAll();
		return userlist;	
	}
	
	//Exception handling
	@GetMapping("{userid}")
	public UserInfo getUserInfo(@PathVariable ("userid") int userid) {
		System.out.println(userid);
		return userService.getUser(userid);
		
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody UserInfo userInfo) {
		userRepository.save(userInfo);	
		return "Insert Successfully";	
	}
	
	@PutMapping("/update")
	public String update(@RequestBody UserInfo userInfo) {
		userRepository.save(userInfo);	
		return "update Successfully";	
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestBody UserInfo userInfo) {
		userRepository.delete(userInfo);	
		return "Delete Successfully";	
	}
	 

	@GetMapping("/get")
	public List<ProductInfo> getal(){
		List<ProductInfo> productlist = (List<ProductInfo>) productRepository.findAll();
		return productlist;	
	}
	
	@PostMapping("/add")
	public String add(@RequestBody ProductInfo productInfo) {
		productRepository.save(productInfo);
		return "Insert Successfully in H2";	
	}
	
	@PutMapping("/upgrade")
	public String upgrade(@RequestBody ProductInfo productInfo) {
		productRepository.save(productInfo);
		return "Upgarde Successfully in H2";	
	}
	
	
	@DeleteMapping("/remove")
	public String Remove(@RequestBody ProductInfo productInfo) {
		productRepository.delete(productInfo);
		return "Remove Successfully in H2";	
	}
	

}
