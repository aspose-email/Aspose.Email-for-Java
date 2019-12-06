package com.aspose.email.examples.outlook.pst;

import com.aspose.email.PersonalStorage;
import com.aspose.email.examples.Utils;

public class PSTPasswordValidation {
	
	public static String dataDir = Utils.getSharedDataDir(PSTPasswordValidation.class) + "outlook/";
	
	public static void main(String[] args) {
		// ExStart:1
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "passwordprotectedPST.pst");
		System.out.println("The storage is password protected - " + pst.getStore().isPasswordProtected());
		System.out.println("Password is valid - " + pst.getStore().isPasswordValid("Password1"));
		pst.dispose();
		// ExEnd:1
		System.out.println("PSTPasswordValidation executed successfully");
	}

}
