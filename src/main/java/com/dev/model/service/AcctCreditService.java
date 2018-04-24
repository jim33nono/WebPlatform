package com.dev.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.model.bean.AcctCredit;
import com.dev.model.dao.AcctCreditDao;
import com.google.common.base.Optional;

@Service
@Transactional
public class AcctCreditService {

	@Autowired
	private AcctCreditDao acctCreditDao;

	public List<AcctCredit> findAll() {
		return acctCreditDao.findAll();
	}

	public Optional<AcctCredit> findByAcctId(String acctId, String merchant) {
		StringBuilder str = new StringBuilder();
		str.append(acctId).append("@").append(merchant);
		return acctCreditDao.findByAcctId(str.toString());
	}
	
	public void updateAcctCredit(AcctCredit acctCredit) {
		acctCreditDao.updateAcctCredit(acctCredit);
	}

}
