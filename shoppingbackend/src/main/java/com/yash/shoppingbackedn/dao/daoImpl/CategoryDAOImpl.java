package com.yash.shoppingbackedn.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.shoppingbackedn.dao.CategoryDAO;
import com.yash.shoppingbackedn.dto.Category;


@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description of television");
		category.setImageUrl("CAT_1.png");
		
		categories.add(category);
		
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description of mobile");
		category.setImageUrl("CAT_3.png");
		
		categories.add(category);
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description of laptop");
		category.setImageUrl("CAT_2.png");
		
		categories.add(category);
		
		
		
		
	}
	
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//for loop for each catogry
		
		for(Category category : categories) {
			
			if(category.getId() == id) 
				return category;
		}
		
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			 sessionFactory.getCurrentSession().persist(category);
			
			return true;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return false;
		}
		
	}

	
	

}
