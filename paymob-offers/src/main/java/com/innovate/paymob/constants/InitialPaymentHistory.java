package com.innovate.paymob.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialPaymentHistory {
	
	public static List<Long> mobileNumberList = Arrays.asList(
			9898989898L,
			3434343434L,
			4545454545L,
			6767676767L,
			7979797979L
			);
	public static Map<Long, Long> transactionHistory = new HashMap<>();
	static {
		transactionHistory.put(9898989898L, 60000L);
		transactionHistory.put(3434343434L, 100000L);
		transactionHistory.put(4545454545L, 20000L);
		transactionHistory.put(6767676767L, 10000L);
		transactionHistory.put(7979797979L, 300000L);
	}
}
