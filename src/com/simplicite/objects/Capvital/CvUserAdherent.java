package com.simplicite.objects.Capvital;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvUser
 */
public class CvUserAdherent extends CvUser {
	private static final long serialVersionUID = 1L;

	@Override
	public List<String> preValidate() {
		super.preValidate();
		List<String> msgs = new ArrayList<>();
		if (isMainInstance()) {
			setFieldValue("cvUserProfile", "Adherent");
		}
		return msgs;
	}
}
