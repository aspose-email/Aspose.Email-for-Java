package com.aspose.email.examples.email;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.io.ByteArrayOutputStream;

public class TrackDocumentConversionProgress {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(TrackDocumentConversionProgress.class) + "email/";

		String fileName = dataDir + "test.eml";
		MailMessage msg = MailMessage.load(fileName);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		EmlSaveOptions opt = new EmlSaveOptions(MailMessageSaveType.getEmlFormat());
		opt.setCustomProgressHandler( new ConversionProgressEventHandler() {
			public void invoke(ProgressEventHandlerInfo info) {
				showEmlConversionProgress(info);
			}
		});
		msg.save(bos, opt);
		// ExEnd:1
	}

	// ExStart:2
	private static void showEmlConversionProgress(ProgressEventHandlerInfo info)
	{
		int total;
		int saved;
		switch (info.getEventType()) {
			case ProgressEventType.MimeStructureCreated:
				total = info.getTotalMimePartCount();
				saved = info.getSavedMimePartCount();
				System.out.println("MimeStructureCreated - TotalMimePartCount: " + total);
				System.out.println("MimeStructureCreated - SavedMimePartCount: " + saved);
				break;
			case ProgressEventType.MimePartSaved:
				total = info.getTotalMimePartCount();
				saved = info.getSavedMimePartCount();
				System.out.println("MimePartSaved - TotalMimePartCount: " + total);
				System.out.println("MimePartSaved - SavedMimePartCount: " + saved);
				break;
			case ProgressEventType.SavedToStream:
				total = info.getTotalMimePartCount();
				saved = info.getSavedMimePartCount();
				System.out.println("SavedToStream - TotalMimePartCount: " + total);
				System.out.println("SavedToStream - SavedMimePartCount: " + saved);
				break;
		}
	}
	// ExEnd:2
}
