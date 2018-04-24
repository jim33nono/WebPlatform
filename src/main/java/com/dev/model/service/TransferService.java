package com.dev.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.model.bean.Transfer;
import com.dev.model.dao.TransferDao;
import com.google.common.base.Optional;

@Service
@Transactional
public class TransferService {

	@Autowired
	private TransferDao transferDao;

	public List<Transfer> findAll() {
		return transferDao.findAll();
	}

	public Optional<Transfer> findByTicketId(String ticketId) {
		return transferDao.findByTicketId(ticketId);
	}
	
	public Optional<Transfer> findByTransferId(String transferId) {
		return transferDao.findByTransferId(transferId);
	}

	public void addTransfer(Transfer transfer) {
		transferDao.addTransfer(transfer);
	}

}
