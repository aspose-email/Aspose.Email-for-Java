package com.aspose.email.examples.outlook.olm;

import com.aspose.email.OlmFolder;
import com.aspose.email.OlmStorage;
import com.aspose.email.examples.Utils;

import java.util.List;

public class CountItemsInOLMFolder {

	// The path to the File directory.
	public static String dataDir = Utils.getSharedDataDir(CountItemsInOLMFolder.class) + "outlook/";
	// ExStart:1
	public static void main(String[] args) {
		OlmStorage storage = new OlmStorage(dataDir + "SampleOLM.olm");
		PrintMessageCount(storage.getFolderHierarchy());
	}

	public static void PrintMessageCount(List<OlmFolder> folders) {
		for (OlmFolder folder : folders) {
			// print the current folder path
			System.out.println("Message Count [" + folder.getName() + "]: " + folder.getMessageCount());
		}
	}
	// ExEnd:1
}
