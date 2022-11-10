package com.simplicite.objects.Capvital;

import java.util.*;

import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.simplicite.util.*;
import com.simplicite.util.exceptions.*;
import com.simplicite.util.tools.*;

/**
 * Business object CvFinancialClaimImport
 */
public class CvFinancialClaimImport extends ObjectDB {
	private static final long serialVersionUID = 1L;

	@Override
	public String postSave() {
		String documentId = getFieldValue("cvFcClaimImportFile");
		DocumentDB doc = DocumentDB.getDocument(documentId, getGrant());
		CSVTool tool = new CSVTool(',', '\0');
		try {
			java.io.InputStream stream = doc.getInputStream();
			//CSVTool.parse()
		} catch(Exception e) {
			AppLog.error(getClass(), "postSave", "An error occured during csv parsing", e, getGrant());
		}
		return "";
	}

	private void parseCsv() {

	}
}
