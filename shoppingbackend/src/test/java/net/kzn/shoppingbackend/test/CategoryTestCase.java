package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		
		// Adding firt category

		category.setName("Laptop");
		category.setDescription("Descripcionde una laptop");
		category.setImageURL("CAT_3.png");

		assertEquals("addicion exitosa en tabla categoria",true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		assertEquals("Se alcanzo una categoria desde la tabla","Laptop", category.getName());
	}*/
	
	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		category.setName("portatil");
		assertEquals("Se actualizo una categoria en la tabla",true, categoryDAO.update(category));
	}
}
