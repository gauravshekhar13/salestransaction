package com.websystique.springboot.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.User;
import com.websystique.springboot.service.UserService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Users---------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		User user = userService.findById(id);
		if (user == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		
		Double taxamount = 0.0;
		
		if(user.getImpfood()!=0){
			double d = 0.0;
			double foodtax = (user.getImpfood()*0.05)*100;
			double reminder = (Math.floor(foodtax))%5;
			if(reminder!=0){
			foodtax = ((5-reminder)+foodtax)/100;
			d = user.getImpfood()+foodtax;
			}
			
			else{
				foodtax = ( user.getImpfood() * 0.05);
				d =user.getImpfood()+ foodtax;
			}
			user.setImpfood((double) Math.floor(d * 100) / 100);	
			taxamount= taxamount+foodtax;
		}
		
		if(user.getImpperfume()!=0){
			
			double d = 0.0;
			double perfumetax = ((user.getImpperfume()*0.1)*100) + ((user.getImpperfume()*0.05)*100);
			double reminder = (Math.floor(perfumetax))%5;
			
			if(reminder!=0){
			perfumetax = ((5-reminder)+perfumetax)/100;
			d = user.getImpperfume()+perfumetax;
			}
			
			else{
				perfumetax = (user.getImpperfume()*0.1) + (user.getImpperfume()*0.05);
				d = user.getImpperfume()+ perfumetax;
			}
			user.setImpperfume((double) Math.floor(d * 100) / 100);
			taxamount = taxamount+perfumetax;
			
		}
		if(user.getPerfume()!=0){
			double perfumetax =((user.getPerfume()*0.1)*100);
			double reminder = (Math.floor(perfumetax))%5;
			double d = 0.0;
			
			if(reminder!=0){
				perfumetax = ((5-reminder)+perfumetax)/100;
				d = user.getPerfume()+perfumetax;
				}
				
				else{
					perfumetax = (user.getPerfume()*0.1);
					d = user.getImpperfume()+ perfumetax;
				}
			user.setPerfume((double) Math.floor(d * 100) / 100);
			taxamount = taxamount+ perfumetax;
		}
		

		 if(user.getAccessories()!=0){
			double accesstax =(user.getAccessories()*0.1)*100;
			double reminder = (Math.floor(accesstax))%5;
			double d = 0.0;
			if(reminder!=0){
			accesstax = ((5-reminder)+accesstax)/100;
			d = user.getAccessories()+accesstax;
			}
			
			else{
				d = user.getAccessories()+ (user.getAccessories()*0.1);
			}
			
			
			user.setAccessories((double) Math.floor(d * 100) / 100);
			taxamount = taxamount+ accesstax;
		}
		

		 
		 double total = user.getBook()+user.getFood()+user.getPerfume()+user.getAccessories()+user.getMedicine()+user.getImpfood()+user.getImpperfume();
		user.setTotalTax((double) Math.floor(taxamount * 100) / 100);
		user.setTotal((double) Math.round(total * 100) / 100);
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setFood(user.getFood());
		currentUser.setPerfume(user.getPerfume());
		currentUser.setBook(user.getBook());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		User user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}