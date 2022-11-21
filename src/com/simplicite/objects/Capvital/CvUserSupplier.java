package com.simplicite.objects.Capvital;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvUserSupplier
 */
public class CvUserSupplier extends CvUser {
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<String> preValidate() {
		super.preValidate();
		List<String> msgs = new ArrayList<>();
		if (isMainInstance()) {
			setFieldValue("cvUserProfile", "Supplier");
		}
		return msgs;
	}
}
