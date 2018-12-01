package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Transactional
	public Integer saveItem(Item it) {
		return dao.saveItem(it);
	}

	@Transactional
	public void updateItem(Item it) {
		dao.updateItem(it);

	}

	@Transactional
	public void deleteItem(Integer itemId) {
		dao.deleteItem(itemId);

	}

	@Transactional(readOnly=true)
	public Item getOneItemById(Integer itemId) {
		return dao.getOneItemById(itemId);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

	

}
