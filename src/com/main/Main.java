package com.main;

import com.dao.CategoryDAO;
import com.dao.CategoryDAOImpl;

public class Main {

//	utilizziamo il main per testare la funzionalita e per far girare i metodi di crud creati nelle dao

	public static void main(String[] args) {

		CategoryDAO dao = new CategoryDAOImpl();

		/* List<Category> categories = dao.getAllCategories(); */

		/* for (Category category : categories) {
			System.out.println(category.getName());
		}
 */
		/* dao.insertCategory(new Category("Pantalone")); */

		/* dao.updateCategory(new Category(18, "Scarpa")); */

		dao.deleteCategory(17);

	}

}
