package com.aspose.email.examples.smtp;

import com.aspose.email.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendWithMultiConnection {

	public static void main(String[] args) {
		//ExStart: 1
		SmtpClient smtpClient = new SmtpClient();
		smtpClient.setHost("<HOST>");
		smtpClient.setUsername("<USERNAME>");
		smtpClient.setPassword("<PASSWORD>");
		smtpClient.setPort(587);
		smtpClient.setSupportedEncryption(EncryptionProtocols.Tls);
		smtpClient.setSecurityOptions(SecurityOptions.SSLExplicit);

		List<MailMessage> messages = new ArrayList<>();
		for (int i = 0; i < 20; i++)
		{
			MailMessage message = new MailMessage(
					"<EMAIL ADDRESS>",
					"<EMAIL ADDRESS>",
					"Test Message - " + UUID.randomUUID(),
					"SMTP Send Messages with MultiConnection");
			messages.add(message);
		}

		smtpClient.setConnectionsQuantity(5);
		smtpClient.setUseMultyConnection(MultyConnectionMode.Enable);
		smtpClient.send(messages);
		//ExEnd: 1

		System.out.println("SendWithMultiConnection executed successfully.");
	}

}
