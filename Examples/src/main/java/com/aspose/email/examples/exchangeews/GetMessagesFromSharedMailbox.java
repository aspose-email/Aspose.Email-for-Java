package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.MapiMessage;
import com.aspose.email.system.NetworkCredential;

public class GetMessagesFromSharedMailbox {

	public static void main(String[] args) {
		//ExStart: 1
		String mailboxUri = "<HOST>";
		String domain = "";
		String username = "<EMAIL ADDRESS>";
		String password = "<PASSWORD>";
		String sharedEmail = "<SHARED EMAIL ADDRESS>";
		NetworkCredential credentials = new NetworkCredential(username, password, domain);
		IEWSClient client = EWSClient.getEWSClient(mailboxUri, credentials);

		String[] items = client.listItems(sharedEmail, "Inbox");

		for (String item : items)
		{
			MapiMessage msg = client.fetchItem(item);
			System.out.println("Subject:" + msg.getSubject());
		}
		client.dispose();
		//ExEnd: 1
		System.out.println("GetMessagesFromSharedMailbox executed successfully");
	}

}
