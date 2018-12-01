package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	
	public Integer saveItem(Item it);
	public void updateItem(Item it);
	public void deleteItem(Integer itemId);
	public Item getOneItemById(Integer itemId);
	public List<Item> getAllItems();
	
}
