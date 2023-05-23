package com.dao;

import java.util.List;

import com.entity.Category;
import com.provider.ProviderManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

// la classe implementa tutte le operazioi di crud definite all'interno dell'interfaccia

public class CategoryDAOImpl implements CategoryDAO {

//	utilizziamo i metodi initRoutine e closeRoutine per avviare e chiudere le transazioni

	private EntityManagerFactory emf;
	private EntityManager em;

//	implementazione delle operazioni di crud
	@Override
	public void insertCategory(Category category) {

		initRoutine();
		em.persist(category);
		closeRoutine();

	}

	@Override
	public void updateCategory(Category category) {

		initRoutine();
		em.merge(category);
		closeRoutine();

	}

	@Override
	public void deleteCategory(int categoryId) {
		initRoutine();
		em.remove(em.find(Category.class, categoryId));
		closeRoutine();

	}

	@Override
	public List<Category> getAllCategories() {
		initRoutine();
		List<Category> category = em.createNamedQuery("Category.findAll", Category.class).getResultList();
		closeRoutine();
		return category;
	}

//	metodi delle transazioni
	private void closeRoutine() {
		try {
			ProviderManager.commitTransaction(em);
		} catch (RollbackException rbe) {
			System.err.println("Transazione fallita: eseguo il rollback.");
			rbe.printStackTrace();
			ProviderManager.rollbackTransaction(em);
		} finally {
			ProviderManager.closeTransaction(em);
			ProviderManager.closeEntityManagerFactory(emf);
		}
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);
		ProviderManager.beginTransaction(em);
	}

}
