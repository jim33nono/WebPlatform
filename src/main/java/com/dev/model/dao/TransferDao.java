package com.dev.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.model.bean.Transfer;
import com.google.common.base.Optional;

@Repository
@SuppressWarnings("unchecked")
public class TransferDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;

	}

	public List<Transfer> findAll() {
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM Transfer ORDER BY txId DESC");
		List<Transfer> results = query.list();
		return results;
	}

	public Optional<Transfer> findByTicketId(String ticketId) {
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM Transfer WHERE ticketId = :ticketId");
		query.setParameter("ticketId", ticketId);
		List<Transfer> result = query.list();
		return (Optional<Transfer>) (result.isEmpty() ? Optional.absent() : Optional.of(result.get(0)));
	}

	public Optional<Transfer> findByTransferId(String transferId) {
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("FROM Transfer WHERE transferId = :transferId ORDER BY operationTime DESC");
		query.setParameter("transferId", transferId);
		List<Transfer> result = query.list();
		return (Optional<Transfer>) (result.isEmpty() ? Optional.absent() : Optional.of(result.get(0)));
	}
	

	public void addTransfer(Transfer transfer) {
		getSessionFactory().getCurrentSession().saveOrUpdate(transfer);
	}

}
