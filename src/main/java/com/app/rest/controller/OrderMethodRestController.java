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

import com.app.model.OrderMethod;

import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/order/data")
public class OrderMethodRestController {
	@Autowired
	private IOrderMethodService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<OrderMethod> om=service.getAllOrderMethods();
		if(om == null|| om.isEmpty()) {
			//data not available
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<OrderMethod>> (om, HttpStatus.OK);
		}
		return message;
		}
	


@GetMapping("/get/{id}")
public ResponseEntity<?> getOne(@PathVariable Integer id){
	ResponseEntity<?> message=null;
	OrderMethod om=service.getOneOrderMethodById(id);
	if(om == null){
		//data not available
		message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	else {
		message=new ResponseEntity<OrderMethod> (om, HttpStatus.OK);
	}
	return message;
	}


@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String> message=null;
	try {
	service.deleteOrderMethod(id);
		message=new ResponseEntity<String> ("OrderMethod deleted Successfully",  HttpStatus.OK);	
	}
	catch(Exception e){
		message=new ResponseEntity<String> ("OrderMethod not Found", HttpStatus.BAD_REQUEST);	
	}
	return message;
	}

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody OrderMethod om){
	ResponseEntity<String> message=null;
	try {
		Integer id=service.saveOrderMethod(om);
		message=new ResponseEntity<String>("Order Registered Successfully with id: "+id, HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	return message;
}

@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody OrderMethod om){
	ResponseEntity<String> message=null;
	try {
		service.updateOrderMethod(om);
		message=new ResponseEntity<String>("Order updated ", HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>("Order '"+om.getId()+"' Not Found", HttpStatus.BAD_REQUEST);
		
	}
	return message;
}

}


