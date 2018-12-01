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

import com.app.model.ShipmentType;

import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/shipment/data")
public class ShipmentRestController {
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<ShipmentType> st=service.getAllShipmentTypes();
		if(st == null|| st.isEmpty()) {
			//data not available
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<ShipmentType>> (st, HttpStatus.OK);
		}
		return message;
		}
	


@GetMapping("/get/{id}")
public ResponseEntity<?> getOne(@PathVariable Integer id){
	ResponseEntity<?> message=null;
	ShipmentType type=service.getOneShipmentTypeById(id);
	if(type== null){
		//data not available
		message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	else {
		message=new ResponseEntity<ShipmentType> (type, HttpStatus.OK);
	}
	return message;
	}


@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String> message=null;
	try {
	service.deleteShipmentType(id);;
		message=new ResponseEntity<String> ("Shipment deleted Successfully",  HttpStatus.OK);	
	}
	catch(Exception e){
		message=new ResponseEntity<String> ("Shipment not Found", HttpStatus.BAD_REQUEST);	
	}
	return message;
	}

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody ShipmentType st){
	ResponseEntity<String> message=null;
	try {
		Integer id=service.saveShipmentType(st);
		message=new ResponseEntity<String>("Shipment Registered Successfully with id: "+id, HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	return message;
}

@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody ShipmentType st){
	ResponseEntity<String> message=null;
	try {
		service.updateShipmentType(st);;
		message=new ResponseEntity<String>("Shipment updated ", HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>("Shipment '"+st.getId()+"' Not Found", HttpStatus.BAD_REQUEST);
		
	}
	return message;
}

}


