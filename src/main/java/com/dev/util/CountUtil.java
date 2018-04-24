package com.dev.util;

import java.math.BigDecimal;

public class CountUtil {
	
	public static BigDecimal calculateBalance (BigDecimal balAmt, BigDecimal penAmt, BigDecimal betAmt) {
		return balAmt.add(penAmt).subtract(betAmt)  ;
	}
	
	public static BigDecimal plus (BigDecimal num1, BigDecimal num2) {
		return num1.add(num2);
	}
	
	public static BigDecimal subtract (BigDecimal num1, BigDecimal num2) {
		return num1.subtract(num2);
	}
	
}
