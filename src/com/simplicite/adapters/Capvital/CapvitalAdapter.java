package com.simplicite.adapters.Capvital;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.integration.*;

import com.simplicite.util.tools.*;

/**
 * Adapter ExampleCsvAdapter
 */
public class CapvitalAdapter extends CSVLineBasedAdapter {
	private static final long serialVersionUID = 1L;
	private ObjectDB financialClaim;

	private static class CapvitalAdapterException extends Exception{
		public CapvitalAdapterException(String message){
			super(message);
		}
	}
	
	@Override
	public String preProcess(){
		// set CSV separator
		setSeparator(';');
		financialClaim = getGrant().getTmpObject("CvFinancialClaim");
		return null;
	}
	
	@Override
	public String processValues(long lineNumber, String[] values){	
		// Good practice: handle errors with exceptions		
		try{

			// add some logs to the .log file (added in the imports supervisor object)
			appendLog("=== Processing line #"+lineNumber+" : "+Arrays.toString(values));
			processWithExceptions(lineNumber, values);
		}
		catch(CapvitalAdapterException e){
			// add some logs to the .err file (added in the imports supervisor object)
			appendError("=== Error with line #"+lineNumber+" : "+Arrays.toString(values));
			appendError(e);

			// change import status to impact the supervisor object
			setStatus(SystemXML.SUPERVISOR_STATUS_IMPORT_ERROR);
		}

		// returned String gets added to a XML subsequently imported.
		// in this case we do not append anything to XML subsequently imported,
		// as we directly create the objects instead
		return null; 
	}

	@Override
	public void postProcess(){
		appendLog("End Process with status "+getStatus());
		// to generate a subsequently imported XML, call super.postProcess()
		// doing so will add a closing <simplicite> tag
	}

	public void processWithExceptions(long lineNumber, String[] values) throws CapvitalAdapterException{
		String createMsg;
		synchronized(financialClaim){
			financialClaim.resetValues(true);
			String dbDate = values[0].split("/", -1)[2] +"-"+ values[0].split("/", -1)[1]+ "-"+ values[0].split("/", -1)[0];
			financialClaim.setFieldValue("cvFcDate", dbDate);
			financialClaim.setFieldValue("cvFcInvoice", values[1]);
			financialClaim.setFieldValue("cvFcGrossSales", values[2]);
			financialClaim.setFieldValue("CvFinancialClaim_CvAccount_id", 1);
			financialClaim.setFieldValue("CvFinancialClaim_CvAccount_id.cvAccountName", values[3]);
			financialClaim.setFieldValue("CvFinancialClaim_CvFinancialClaimImport_id", getParameter("importId"));
			createMsg = financialClaim.create();
			if(createMsg != null) AppLog.info(createMsg, getGrant());
		}
		if(!Tool.isEmpty(createMsg)){
			throw new CapvitalAdapterException(createMsg);
		}
	}
}