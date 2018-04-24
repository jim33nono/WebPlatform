package com.dev.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.model.bean.Merchant;

@Repository
public class MerchantDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public List<Merchant> findAll() {
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM Merchant");
		@SuppressWarnings("unchecked")
		List<Merchant> results = query.list();
		return results;
	}

}
