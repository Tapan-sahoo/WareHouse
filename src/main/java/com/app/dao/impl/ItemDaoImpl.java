package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;


@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveItem(Item it) {

		return (Integer) ht.save(it);
	}

	@Override
	public void updateItem(Item it) {
		ht.update(it);

	}

	@Override
	public void deleteItem(Integer itemId) {
		Item i = new Item();
		i.setItemId(itemId);
		ht.delete(i);

	}

	@Override
	public Item getOneItemById(Integer itemId) {
		return ht.get(Item.class, itemId);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

	
}
