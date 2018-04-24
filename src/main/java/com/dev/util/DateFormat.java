package com.dev.util;

import java.util.Date;
import java.util.List;

import com.dev.model.bean.Transfer;

public class DateFormat {
	public List<Transfer> format(List<Transfer> list) {
		for (Transfer transfer : list) {
			String str = transfer.getOperationTime().toString();
			long foo = Long.parseLong(str);
			Date date = new Date(foo);
		}
		return null;
	}

}
