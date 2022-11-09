package com.simplicite.objects.Capvital;

import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvUser
 */
public class CvUser extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void postLoad() {
		super.postLoad();
		Grant g = getGrant();
		getField("row_module_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_image_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_home_id").setVisibility(ObjectField.VIS_HIDDEN);
		getField("usr_active").setVisibility(ObjectField.VIS_HIDDEN);
		
		setMenuStates(false);
		
		getField("usr_first_name").setRequired(true);
		getField("usr_last_name").setRequired(true);
		getField("usr_email").setRequired(true);
	}
	
	@Override
	public List<String> preValidate() {
		List<String> msgs = new ArrayList<>();
		Grant g = getGrant();
		if (isMainInstance())
			setFieldValue("row_module_id", ModuleDB.getModuleId("KeycloakAuth"));
			if (Tool.isEmpty(getFieldValue("usr_role")))
				msgs.add(Message.formatError("KEY_EXTUSER_ROLE", null, "usr_role"));
			if (Tool.isEmpty(getFieldValue("usr_account")))
				msgs.add(Message.formatError("KEY_EXTUSER_ACCOUNT", null, "usr_account"));
		return msgs;
	}
}
