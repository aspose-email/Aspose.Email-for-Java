package com.aspose.email.examples.outlook.pst;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class GetFoldersCreatedByUserOnly {
	
	public static String dataDir = Utils.getSharedDataDir(GetFoldersCreatedByUserOnly.class) + "outlook/";
	
	public static void main(String[] args) {
		// ExStart:1
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "Outlook.pst");
		try {
			PersonalStorageQueryBuilder queryBuilder = new PersonalStorageQueryBuilder();
			queryBuilder.getOnlyFoldersCreatedByUser().equals(true);

			FolderInfoCollection subfolders = pst.getRootFolder().getSubFolders(queryBuilder.getQuery());
			for(FolderInfo folder : subfolders) {
				System.out.println(folder.getDisplayName());
			}
		} finally {
			pst.dispose();
		}
		// ExEnd:1
	}

}
