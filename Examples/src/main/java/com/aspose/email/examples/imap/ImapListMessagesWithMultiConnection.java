package com.aspose.email.examples.imap;

import com.aspose.email.*;

public class ImapListMessagesWithMultiConnection {

	public static void main(String[] args) {
		//ExStart: 1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		imapClient.selectFolder("Inbox");
		imapClient.setConnectionsQuantity(5);
		imapClient.setUseMultiConnection(MultiConnectionMode.Enable);
		long multiConnectionModeStartTime = System.nanoTime();
		ImapMessageInfoCollection messageInfoCol1 = imapClient.listMessages(true);
		long multiConnectionModeTimeSpan = (System.nanoTime() - multiConnectionModeStartTime);

		imapClient.setUseMultiConnection(MultiConnectionMode.Disable);
		long singleConnectionModeStartTime = System.nanoTime();
		ImapMessageInfoCollection messageInfoCol2 = imapClient.listMessages(true);
		long singleConnectionModeTimeSpan = (System.nanoTime() - singleConnectionModeStartTime);

		double performanceRelation = (double)singleConnectionModeTimeSpan / (double)multiConnectionModeTimeSpan;
		System.out.println("Performance Relation: " + performanceRelation);
		//ExEnd: 1

		System.out.println("ImapListMessagesWithMultiConnection executed successfully.");
	}
}
