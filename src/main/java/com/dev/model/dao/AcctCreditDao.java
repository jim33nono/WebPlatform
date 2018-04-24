package com.dev.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.model.bean.AcctCredit;
import com.google.common.base.Optional;

@Repository
@SuppressWarnings("unchecked")
public class AcctCreditDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public List<AcctCredit> findAll() {
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM AcctCredit");
		List<AcctCredit> results = query.list();
		return results;
	}

	public Optional<AcctCredit> findByAcctId(String acctId) {
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM AcctCredit WHERE acctId = :acctId");
		query.setParameter("acctId", acctId);
		List<AcctCredit> result = query.list();
		return checkOptional(result);
	}

	private Optional<AcctCredit> checkOptional(List<AcctCredit> result) {
		return (Optional<AcctCredit>) (result.isEmpty() ? Optional.absent() : Optional.of(result.get(0)));
	}

	public void updateAcctCredit(AcctCredit acctCredit) {
		getSessionFactory().getCurrentSession().saveOrUpdate(acctCredit);
	}

}
