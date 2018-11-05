package com.aspose.email.examples.outlook.olm;

import com.aspose.email.MapiMessage;
import com.aspose.email.OlmFolder;
import com.aspose.email.OlmStorage;
import com.aspose.email.examples.Utils;

public class LoadAndReadOLMFile {

	// The path to the File directory.
	public static String dataDir = Utils.getSharedDataDir(LoadAndReadOLMFile.class) + "outlook/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OlmStorage storage = new OlmStorage(dataDir + "OutlookforMac.olm");
		try {
		    for (OlmFolder folder : storage.getFolderHierarchy()) {
		        if (folder.hasMessages()) {
		            // extract messages from folder
		            for (MapiMessage msg : storage.enumerateMessages(folder)) {
		            	System.out.println("Subject: " + msg.getSubject());
		            }
		        }

		        // read sub-folders
		        if (folder.getSubFolders().size() > 0) {
		            for (OlmFolder subFolder : folder.getSubFolders()) {
		            	System.out.println("Subfolder: " + subFolder.getName());
		            }
		        }
		    }
		} finally {
		    storage.dispose();
		}

	}

}
