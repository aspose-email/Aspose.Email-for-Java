package com.aspose.email.examples.imap;

import com.aspose.email.*;

public class ImapReadOnlyMode {

	public static void main(String[] args) {
		//ExStart: 1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		ImapQueryBuilder imapQueryBuilder = new ImapQueryBuilder();
		imapQueryBuilder.hasNoFlags(ImapMessageFlags.isRead()); /* get unread messages. */
		MailQuery query = imapQueryBuilder.getQuery();

		imapClient.setReadOnly(true);
		imapClient.selectFolder("Inbox");
		ImapMessageInfoCollection messageInfoCol = imapClient.listMessages(query);
		System.out.println("Initial Unread Count: " + messageInfoCol.size());
		if (messageInfoCol.size() > 0)
		{
			imapClient.fetchMessage(messageInfoCol.get_Item(0).getSequenceNumber());

			messageInfoCol = imapClient.listMessages(query);
			// This count will be equal to the initial count
			System.out.println("Updated Unread Count: " + messageInfoCol.size());
		}
		else
		{
			System.out.println("No unread messages found");
		}
		//ExEnd: 1

		System.out.println("ImapReadOnlyMode executed successfully.");
	}
}
