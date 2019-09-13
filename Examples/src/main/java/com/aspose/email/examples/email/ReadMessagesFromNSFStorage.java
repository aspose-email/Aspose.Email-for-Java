package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.NotesStorageFacility;
import com.aspose.email.examples.Utils;

public class ReadMessagesFromNSFStorage {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadMessagesFromNSFStorage.class) + "email/";

		NotesStorageFacility nsf = new NotesStorageFacility(dataDir + "SampleNSF.nsf");
		try {
			for (MailMessage eml : nsf.enumerateMessages()) {
				System.out.println(eml.getSubject());
			}
		} finally {
			nsf.dispose();
		}
		// ExEnd:1
	}
}