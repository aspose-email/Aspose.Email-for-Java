package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiMessage;
import com.aspose.email.MessageInfo;
import com.aspose.email.MessageInfoCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class CreateFolderHierarchyUsingStringNotation {

	public static void main(String[] args) {
		//ExStart: CreateContactInSubFolderOfContacts
		String dataDir = Utils.getSharedDataDir(AccessContactInformationFromPSTFile.class) + "outlook/";

		PersonalStorage personalStorage = PersonalStorage.create(dataDir + "CreateFolderHierarchyUsingStringNotation.pst", FileFormatVersion.Unicode);
		personalStorage.getRootFolder().addSubFolder("Inbox\\Folder1\\Folder2", true);
		//ExEnd: CreateFolderHierarchyUsingStringNotation
	}
}
