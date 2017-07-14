package com.aspose.email.examples.email;

import com.aspose.email.EmlLoadOptions;
import com.aspose.email.FileFormatType;
import com.aspose.email.FileFormatUtil;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;

public class PreservingEmbeddedMessageFormatduringLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PreservingEmbeddedMessageFormatduringLoading();
	}
	
	static void PreservingEmbeddedMessageFormatduringLoading()
	{
		//ExStart: PreservingEmbeddedMessageFormatduringLoading
		String dataDir = Utils.getSharedDataDir(DisplayEmailInformation.class) + "email/";

		EmlLoadOptions options = new EmlLoadOptions();
		options.setPreserveEmbeddedMessageFormat(true);
		
		MailMessage mail = MailMessage.load(dataDir + "tnefWithMsgInside.eml", options);

		int fileFormat = FileFormatUtil.detectFileFormat(mail.getAttachments().get_Item(0).getContentStream()).getFileFormatType();

		System.out.println("Embedded message file format: " + fileFormat);
		//ExEnd: PreservingEmbeddedMessageFormatduringLoading
	}

}
