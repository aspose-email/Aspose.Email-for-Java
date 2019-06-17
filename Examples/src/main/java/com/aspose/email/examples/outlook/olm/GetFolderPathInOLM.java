package com.aspose.email.examples.outlook.olm;

import com.aspose.email.OlmFolder;
import com.aspose.email.OlmStorage;
import com.aspose.email.examples.Utils;

import java.util.List;

public class GetFolderPathInOLM {

	// The path to the File directory.
	public static String dataDir = Utils.getSharedDataDir(GetFolderPathInOLM.class) + "outlook/";
	// ExStart:1
	public static void main(String[] args) {
		OlmStorage storage = new OlmStorage(dataDir + "SampleOLM.olm");
		PrintPath(storage, storage.getFolderHierarchy());
	}

	public static void PrintPath(OlmStorage storage, List<OlmFolder> folders) {
		for (OlmFolder folder : folders) {
			// print the current folder path
			System.out.println(folder.getPath());

			if (folder.getSubFolders().size() > 0) {
				PrintPath(storage, folder.getSubFolders());
			}
		}
	}
	// ExEnd:1
}
