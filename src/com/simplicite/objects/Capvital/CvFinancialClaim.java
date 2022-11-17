package com.simplicite.objects.Capvital;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvFinancialClaim
 */
public class CvFinancialClaim extends ObjectDB {
	private static final long serialVersionUID = 1L;

	@Override
	public String preCreate () {
		String msgs = "";

		String date = getFieldValue("cvFcDate");
		String invoice = getFieldValue("cvFcInvoice");
		String sales = getFieldValue("cvFcGrossSales");
		String key = date + invoice + sales;
		setFieldValue("cvFcKey", key);
		return msgs;
	}

	
}
