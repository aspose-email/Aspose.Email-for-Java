package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class CustomOrderOfInformationInMHTML {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(CustomOrderOfInformationInMHTML.class) + "email/";

		MailMessage eml = MailMessage.load(dataDir + "Attachments.eml");
		MhtSaveOptions opt = SaveOptions.getDefaultMhtml();

		eml.save(dataDir + "CustomOrderOfInformationInMHTML_1.mhtml", opt);

		opt.getRenderingHeaders().add(MhtTemplateName.FROM);
		opt.getRenderingHeaders().add(MhtTemplateName.SUBJECT);
		opt.getRenderingHeaders().add(MhtTemplateName.TO);
		opt.getRenderingHeaders().add(MhtTemplateName.SENT);

		eml.save(dataDir + "CustomOrderOfInformationInMHTML_2.mhtml", opt);

		opt.getRenderingHeaders().clear();
		opt.getRenderingHeaders().add(MhtTemplateName.ATTACHMENTS);
		opt.getRenderingHeaders().add(MhtTemplateName.CC);
		opt.getRenderingHeaders().add(MhtTemplateName.SUBJECT);

		eml.save(dataDir + "CustomOrderOfInformationInMHTML_3.mhtml", opt);
		// ExEnd:1
		System.out.println("CustomOrderOfInformationInMHTML executed successfully");
	}

}
