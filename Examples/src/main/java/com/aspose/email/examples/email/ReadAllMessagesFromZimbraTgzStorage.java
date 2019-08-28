package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class ReadAllMessagesFromZimbraTgzStorage {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(ReadAllMessagesFromZimbraTgzStorage.class) + "email/";

		TgzReader reader = new TgzReader(dataDir + "ZimbraSample.tgz");
		try {
			while (reader.readNextMessage()) {
				String directoryName = reader.getCurrentDirectory();
				System.out.println(directoryName);
				MailMessage eml = reader.getCurrentMessage();
				System.out.println(eml.getSubject());
			}
		} finally {
			reader.dispose();
		}
		// ExEnd:1
	}
}
