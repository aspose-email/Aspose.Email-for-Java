package com.aspose.email.examples.imap;

import com.aspose.email.*;

public class ChangeOrderOfEmails {

	public static void main(String[] args) {
		// ExStart:ChangeOrderOfEmails
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		PageSettings pageSettings = new PageSettings();
		pageSettings.setAscendingSorting(true);
		ImapPageInfo pageInfo = imapClient.listMessagesByPage(5, pageSettings);
		ImapMessageInfoCollection messages = pageInfo.getItems();

		for (ImapMessageInfo message : messages)
		{
			System.out.println(message.getSubject() + " -> " + message.getDate().toString());
		}
		// ExEnd:ChangeOrderOfEmails
	}
}
