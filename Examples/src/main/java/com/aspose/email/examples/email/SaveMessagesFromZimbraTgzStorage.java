package com.aspose.email.examples.email;

import com.aspose.email.TgzReader;
import com.aspose.email.examples.Utils;

public class SaveMessagesFromZimbraTgzStorage {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(SaveMessagesFromZimbraTgzStorage.class) + "email/";
		String outputDir = Utils.getSharedDataDir(SaveMessagesFromZimbraTgzStorage.class) + "email/Zimbra/";

		TgzReader reader = new TgzReader(dataDir + "ZimbraSample.tgz");
		try {
			reader.exportTo(outputDir);
		} finally {
			reader.dispose();
		}
		// ExEnd:1
	}
}
