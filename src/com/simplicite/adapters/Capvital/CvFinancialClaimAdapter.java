package com.simplicite.adapters.Capvital;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.integration.*;

import com.simplicite.util.tools.*;

// -----------------------------------------------------------------------------------------------------------
// Note: you should consider using one of com.simplicite.util.integration sub classes instead of SimpleAdapter
// -----------------------------------------------------------------------------------------------------------

/**
 * Adapter CvFinancialClaimAdapter
 */
public class CvFinancialClaimAdapter extends SimpleAdapter {
	private static final long serialVersionUID = 1L;

	/**
	 * Process method
	 */
	@Override
	public void process() throws InterruptedException {
		try {
			
		} catch (Exception e) {
			AppLog.error(null, e, getGrant());
		}
	}
}
