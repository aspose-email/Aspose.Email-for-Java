package com.aspose.email.examples.imap;

import com.aspose.email.*;

public class GetListUnsubscribeHeader {

	public static void main(String[] args) {
		//ExStart: 1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		ImapMessageInfoCollection messageInfoCol = imapClient.listMessages();
		for (ImapMessageInfo imapMessageInfo : messageInfoCol)
		{
			System.out.println("ListUnsubscribe Header: " + imapMessageInfo.getListUnsubscribe());
		}
		//ExEnd: 1

		System.out.println("GetListUnsubscribeHeader executed successfully.");
	}
}
