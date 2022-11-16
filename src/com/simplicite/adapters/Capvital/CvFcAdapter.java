package com.simplicite.adapters.Capvital;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.integration.*;

import com.simplicite.util.tools.*;

/**
 * Adapter ExampleCsvAdapter
 */
public class CvFcAdapter extends CSVLineBasedAdapter {
	private static final long serialVersionUID = 1L;
	private ObjectDB exampleObject;

	// Good practice : use specific exception class
	private static class CvFcAdapterException extends Exception{
		public CvFcAdapter(String message){
			super(message);
		}
	}
	
	public String preProcess(){
		// set CSV separator
		setSeparator(','); 
		exampleObject = getGrant().getProcessObject(lgcObject); 

		// to generate a subsequently imported XML, call super.preProcess()
		// doing so will add a starting <simplicite> tag
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
		catch(ExampleCsvAdapterException e){
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

	public void postProcess(){
		appendLog("End Process with status "+getStatus());
		// to generate a subsequently imported XML, call super.postProcess()
		// doing so will add a closing <simplicite> tag
	}

	public void processWithExceptions(long lineNumber, String[] values) throws ExampleCsvAdapterException{
		String createMsg;
		synchronized(exampleObject){
			exampleObject.resetValues(true);
			exampleObject.setFieldValue("attr1", values[0]);
			exampleObject.setFieldValue("attr2", values[1]);
			exampleObject.setFieldValue("attr3", values[2]);
			createMsg = exampleObject.create();
		}
		if(!Tool.isEmpty(createMsg)){
			throw new ExampleCsvAdapterException(createMsg);
		}
	}
}