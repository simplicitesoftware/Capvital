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
			} catch(java.io.IOException e) {
				AppLog.error(e, g);
			}
			
		}
	}
}
