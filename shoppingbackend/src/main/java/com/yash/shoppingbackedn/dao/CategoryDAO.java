package com.yash.shoppingbackedn.dao;

import java.util.List;

import com.yash.shoppingbackedn.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	
	boolean add(Category category);

}
