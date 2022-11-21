package com.simplicite.objects.Capvital;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;
import com.simplicite.util.tools.Parameters.DocParam;
import com.simplicite.util.Integration;

import ch.simschla.minify.cli.App;

/**
 * Business object CvFinancialClaimImport
 */
public class CvFinancialClaimImport extends ObjectDB {
	private static final long serialVersionUID = 1L;

	public void importCSV(Action action) {
		Grant g = getGrant();
		String lang = g.getLang();
		ObjectField docField = action.getConfirmField(lang, "cvImportActionFile");
		String rowId = this.getRowId();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("importId", rowId);
		DocumentDB doc = docField.getDocument();
		if(doc!=null) {
			try {
				byte[] data = doc.getBytes(true);
				new Integration().importADP(g, "CapvitalAdapter", new ByteArrayInputStream(data), getName(), params);
				importSuccess(doc);
			} catch(java.io.IOException e) {
				AppLog.error(e, g);
			}
		}
	}

	@Override
	public void initAction(Action action) {
		if ("CvImportAction".equals(action.getName())) {
			ObjectField f = action.getConfirmField(getGrant().getLang(), "cvImportActionFile");
			DocumentDB doc =  getField("cvFcImportFile").getDocument();
			f.setDocument(doc);
		}
}

	private void importSuccess(DocumentDB doc) {
		getField("cvFcImportFile").setDocument(doc);
		setFieldValue("cvFcImportStatus", "OK");
		save();
	}

	@Override 
	public void initCreate() {
		getField("cvFcImportFile").setVisibility(ObjectField.VIS_HIDDEN);
	}

	@Override
	public void initList(ObjectDB parent) {
		getField("cvFcImportFile").setVisibility(ObjectField.VIS_HIDDEN);
	}

	@Override
	public void initUpdate() {
		// hide field on update
		DocumentDB docField = getField("cvFcImportFile").getDocument();
		// display field when a file has been uploaded
		if(docField != null) {
			getField("cvFcImportFile").setVisibility(ObjectField.VIS_FORM);
		// or hide field
		} else {
			getField("cvFcImportFile").setVisibility(ObjectField.VIS_HIDDEN);
		}
	}
}
