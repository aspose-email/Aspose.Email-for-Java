package com.aspose.email.examples.outlook.msg;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class CreateV30Contact {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(DistributionList.class) + "outlook/";

		MapiContact contact = new MapiContact();
		contact.setNameInfo(new MapiContactNamePropertySet("Jane", "A.", "Buell"));
		contact.setProfessionalInfo(new MapiContactProfessionalPropertySet("Aspose Pty Ltd", "Social work assistant"));
		contact.getPersonalInfo().setPersonalHomePage("Aspose.com");
		contact.getElectronicAddresses().setEmail1(new MapiContactElectronicAddress("test@test.com"));
		contact.getTelephones().setHomeTelephoneNumber("06605040000");

		VCardSaveOptions opt = new VCardSaveOptions();
		opt.setVersion(VCardVersion.V30);
		contact.save(dataDir + "V30.vcf", opt);
		// ExEnd:1

		System.out.println("CreateV30Contact executed successfully.");
	}

}
