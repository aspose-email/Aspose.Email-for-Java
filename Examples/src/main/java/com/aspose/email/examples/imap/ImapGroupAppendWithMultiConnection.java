package com.aspose.email.examples.imap;

import com.aspose.email.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.aspose.email.PropertyDataType.Guid;

public class ImapGroupAppendWithMultiConnection {

	public static void main(String[] args) {
		//ExStart: 1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		List<MailMessage> messages = new ArrayList<>();
		for (int i = 0; i < 20; i++)
		{
			MailMessage message = new MailMessage(
					"<EMAIL ADDRESS>",
					"<EMAIL ADDRESS>",
					"Test Message - " + UUID.randomUUID(),
					"IMAP Group Append with MultiConnection");
			messages.add(message);
		}

		imapClient.setConnectionsQuantity(5);
		imapClient.setUseMultiConnection(MultiConnectionMode.Enable);
		imapClient.appendMessages(messages);
		//ExEnd: 1

		System.out.println("ImapGroupAppendWithMultiConnection executed successfully.");
	}
}
