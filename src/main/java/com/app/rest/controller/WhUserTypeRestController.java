package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/user/data")
public class WhUserTypeRestController {
	@Autowired
	private IWhUserTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<WhUserType> wu=service.getAllWhUserTypes();
		if(wu == null|| wu.isEmpty()) {
			//data not available
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<WhUserType>> (wu, HttpStatus.OK);
		}
		return message;
		}
	


@GetMapping("/get/{id}")
public ResponseEntity<?> getOne(@PathVariable Integer id){
	ResponseEntity<?> message=null;
	WhUserType wu=service.getOneWhUserTypeById(id);
	if(wu == null){
		//data not available
		message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	else {
		message=new ResponseEntity<WhUserType> (wu, HttpStatus.OK);
	}
	return message;
	}


@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String> message=null;
	try {
	service.deleteWhUserType(id);
		message=new ResponseEntity<String> ("WhUser deleted Successfully",  HttpStatus.OK);	
	}
	catch(Exception e){
		message=new ResponseEntity<String> ("WhUser not Found", HttpStatus.BAD_REQUEST);	
	}
	return message;
	}

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody WhUserType wu){
	ResponseEntity<String> message=null;
	try {
		Integer id=service.saveWhUserType(wu);
		message=new ResponseEntity<String>("WhUser Registered Successfully with id: "+id, HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	return message;
}

@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody WhUserType wu){
	ResponseEntity<String> message=null;
	try {
		service.updateWhUserType(wu);
		message=new ResponseEntity<String>("WhUser updated ", HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>("WhUser '"+wu.getId()+"' Not Found", HttpStatus.BAD_REQUEST);
		
	}
	return message;
}


}


