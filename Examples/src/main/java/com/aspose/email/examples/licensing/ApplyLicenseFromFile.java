package com.aspose.email.examples.licensing;

import java.io.FileNotFoundException;

public class ApplyLicenseFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void ApplyLicenseFromFile()
	{
		//ExStart: ApplyLicenseFromFile
		com.aspose.email.License license = new com.aspose.email.License();
		
		license.setLicense("Aspose.Email.Java.lic");
		//ExEnd: ApplyLicenseFromFile
	}

	public static void ApplyLicenseFromStream() throws FileNotFoundException
	{
		//ExStart: ApplyLicenseFromStream
		com.aspose.email.License license = new com.aspose.email.License();
		
		license.setLicense(new java.io.FileInputStream("Aspose.Email.Java.lic"));
		//ExEnd: ApplyLicenseFromStream
	}
}
