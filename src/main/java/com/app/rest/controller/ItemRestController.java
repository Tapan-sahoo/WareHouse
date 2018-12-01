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

import com.app.model.Item;
import com.app.service.IItemService;

@RestController
@RequestMapping("/item/data")
public class ItemRestController {
	@Autowired
	private IItemService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<Item> item=service.getAllItems();
		if(item == null|| item.isEmpty()) {
			//data not available
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<Item>> (item, HttpStatus.OK);
		}
		return message;
		}
	


@GetMapping("/get/{id}")
public ResponseEntity<?> getOne(@PathVariable Integer id){
	ResponseEntity<?> message=null;
	Item item=service.getOneItemById(id);
	if(item == null){
		//data not available
		message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	else {
		message=new ResponseEntity<Item> (item, HttpStatus.OK);
	}
	return message;
	}


@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String> message=null;
	try {
	service.deleteItem(id);
		message=new ResponseEntity<String> ("Item deleted Successfully",  HttpStatus.OK);	
	}
	catch(Exception e){
		message=new ResponseEntity<String> ("Item not Found", HttpStatus.BAD_REQUEST);	
	}
	return message;
	}

@PostMapping("/save")
public ResponseEntity<String> save(@RequestBody Item item){
	ResponseEntity<String> message=null;
	try {
		Integer id=service.saveItem(item);
		message=new ResponseEntity<String>("Item Registered Successfully with id: "+id, HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	return message;
}

@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody Item item){
	ResponseEntity<String> message=null;
	try {
		service.updateItem(item);;
		message=new ResponseEntity<String>("Order updated ", HttpStatus.OK);
	}
	catch(Exception e) {
		message=new ResponseEntity<String>("Order '"+item.getItemId()+"' Not Found", HttpStatus.BAD_REQUEST);
		
	}
	return message;
}

}


