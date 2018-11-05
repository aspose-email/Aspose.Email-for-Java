package com.aspose.email.examples.licensing;

import com.aspose.email.MailMessage;
import com.aspose.email.Metered;
import com.aspose.email.examples.Utils;
import com.aspose.email.examples.email.DisplayEmailInformation;

public class ApplyMeteredLicense {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//ExStart: ApplyMeteredLicense
		Metered metered = new Metered();
		// Access the SetMeteredKey property and pass public and private keys as parameters
		metered.setMeteredKey("*****", "*****");

		// The path to the documents directory. 
		String dataDir = Utils.getSharedDataDir(DisplayEmailInformation.class) + "email/";

		// Load the document from disk.
		MailMessage eml = MailMessage.load(dataDir + "test.eml");
		//Get the page count of document
		System.out.println(eml.getSubject());
		//ExEnd: ApplyMeteredLicense
	}
}
