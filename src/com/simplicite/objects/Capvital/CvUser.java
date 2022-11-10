package com.simplicite.objects.Capvital;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvUser
 */
public class CvUser extends com.simplicite.objects.System.SimpleUser {
	private static final long serialVersionUID = 1L;

	@Override
	public void postLoad() {
		super.postLoad();
		getField("row_module_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_image_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_home_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_active").setVisibility(ObjectField.VIS_HIDDEN);

	}
	
	@Override
	public List<String> preValidate() {
		super.preValidate();
		List<String> msgs = new ArrayList<>();
		if (isMainInstance()) {
			setFieldValue("row_module_id", ModuleDB.getModuleId("Capvital"));
			setFieldValue("usr_active", 1);
		}
		return msgs;
	}

	@Override
	public String postSave() {
		super.postSave();
		Grant g = getGrant();
		if (g.hasResponsibility("CV_ADMIN") || g.hasResponsibility("ADMIN")) {
			String f = getFieldValue("cvUserProfile");
			if(f.equals("ADH")) {
				Grant.addResponsibility(getRowId(), "CV_ADHERENT");
			} else if (f.equals("SUP")) {
				Grant.addResponsibility(getRowId(), "CV_SUPPLIER");
			}
		}
		return null;
	}
}
