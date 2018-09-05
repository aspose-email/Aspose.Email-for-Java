package com.aspose.email.examples.outlook.pst;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiContact;
import com.aspose.email.MapiDistributionList;
import com.aspose.email.MapiDistributionListEntryIdType;
import com.aspose.email.MapiDistributionListMember;
import com.aspose.email.MapiDistributionListMemberCollection;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;
import com.aspose.email.examples.Utils;

public class UpdateMemberInPSTDistributionListAndAppendAnotherDLToExistingDL {

	public static String dataDir = Utils.getSharedDataDir(UpdateMemberInPSTDistributionListAndAppendAnotherDLToExistingDL.class) + "outlook/";

	public static void main(String[] args) throws Exception {
		// Update Messages in Bulk in PST file
		UpdateMemberInPSTDLAndAppendAnotherDLToExistingDL();		
	}

	private static void UpdateMemberInPSTDLAndAppendAnotherDLToExistingDL() throws Exception {
		//ExStart: UpdateMemberInPSTDistributionListAndAppendAnotherDLToExistingDL
		PersonalStorage personalStorage = PersonalStorage.create("testDL.pst", FileFormatVersion.Unicode);
		try {
		    // Add the contact folder to PST
		    FolderInfo contactFolder = personalStorage.createPredefinedFolder("Contacts", StandardIpmFolder.Contacts);

		    // Create contacts
		    String contactId1 = contactFolder.addMapiMessageItem(new MapiContact("Contact 1", "Contact1@host.com"));
		    String contactId2 = contactFolder.addMapiMessageItem(new MapiContact("Contact 2", "Contact2@host.com"));

		    // Create distribution list on the base of the created contacts
		    MapiDistributionListMember contact1 = new MapiDistributionListMember("Contact 1", "Contact1@host.com");
		    contact1.setEntryIdType(MapiDistributionListEntryIdType.Contact);
		    contact1.setEntryId(fromBase64String(contactId1));

		    MapiDistributionListMember contact2 = new MapiDistributionListMember("Contact 2", "Contact2@host.com");
		    contact2.setEntryIdType(MapiDistributionListEntryIdType.Contact);
		    contact2.setEntryId(fromBase64String(contactId2));
		    MapiDistributionListMemberCollection tmp0 = new MapiDistributionListMemberCollection();
		    tmp0.addItem(contact1);
		    tmp0.addItem(contact2);

		    MapiDistributionList distributionList1 = new MapiDistributionList("Contact list1", tmp0);
		    distributionList1.setBody("Distribution List Body1");
		    distributionList1.setSubject("Sample Distribution List1");

		    // Add distribution list to PST
		    String distributionListId1 = contactFolder.addMapiMessageItem(distributionList1);

		    // Create second distribution list
		    String contactId3 = contactFolder.addMapiMessageItem(new MapiContact("Contact 3", "Contact3@host.com"));

		    MapiDistributionListMember contact3 = new MapiDistributionListMember("Contact 3", "Contact3@host.com");
		    contact3.setEntryIdType(MapiDistributionListEntryIdType.Contact);
		    contact3.setEntryId(fromBase64String(contactId3));
		    MapiDistributionListMemberCollection tmp1 = new MapiDistributionListMemberCollection();
		    tmp1.addItem(contact3);

		    MapiDistributionList distributionList2 = new MapiDistributionList("Contact list2", tmp1);
		    distributionList2.setBody("Distribution List Body1");
		    distributionList2.setSubject("Distribution List1");

		    // Add distribution list to PST
		    String distributionListId2 = contactFolder.addMapiMessageItem(distributionList2);

		    // Add first distribution list to the second
		    MapiDistributionListMember dl = new MapiDistributionListMember(distributionList1.getDisplayName(), null);
		    dl.setEntryIdType(MapiDistributionListEntryIdType.DistributionList);
		    dl.setEntryId(fromBase64String(distributionListId1));

		    distributionList2.getMembers().addItem(dl);

		    // update DL in PST
		    contactFolder.updateMessage(distributionListId2, distributionList2);
		} finally {
		    personalStorage.dispose();
		}
		//ExEnd: UpdateMemberInPSTDistributionListAndAppendAnotherDLToExistingDL
	}
	
	private static byte[] fromBase64String(String data) {
	    return java.util.Base64.getDecoder().decode(data);
	}
}
