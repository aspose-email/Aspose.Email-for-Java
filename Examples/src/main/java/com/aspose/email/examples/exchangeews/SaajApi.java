package com.aspose.email.examples.exchangeews;

import com.aspose.email.*;
import com.aspose.email.system.NetworkCredential;
import com.aspose.email.system.exceptions.Exception;

public class SaajApi {

	public static void main(String[] args) {
		useSaajApi();
		useSaajApiWithAutoDiscoverService();
	}

	private static void useSaajApi(){
		//ExStart: useSaajApi
		try
		{
			String mailboxUri = "<MAILBOX_URL>";
			String username = "<USERNAME>";
			String password = "<PASSWORD>";
			NetworkCredential credentials = new NetworkCredential(username, password);
			EWSClient.useSAAJAPI(true);
			IEWSClient client = EWSClient.getEWSClient(mailboxUri, credentials);

			ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

			for (ExchangeMessageInfo msgInfo : msgCollection)
			{
				System.out.println("Subject:" + msgInfo.getSubject());
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//ExEnd: useSaajApi
		System.out.println("useSaajApi executes successfully!");
	}

	private static void useSaajApiWithAutoDiscoverService(){
		//ExStart: useSaajApiWithAutoDiscoverService
		try
		{
			String mailboxUri = "<MAILBOX_URL>";
			String username = "<USERNAME>";
			String password = "<PASSWORD>";
			EWSClient.useSAAJAPI(true);
			IEWSClient client = EWSClient.getEWSClient(mailboxUri, username, password);

			ExchangeMailboxInfo mailboxInfo = client.getMailboxInfo();

			// Autodiscover Service
			AutodiscoverService service = new AutodiscoverService();
			service.setCredentials(new NetworkCredential(username, password));
			GetUserSettingsResponse response = service.getUserSettings("<USER_SMTP_ADDRESS>", UserSettingName.ExternalEwsUrl, UserSettingName.UserDisplayName);
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//ExEnd: useSaajApiWithAutoDiscoverService
		System.out.println("useSaajApiWithAutoDiscoverService executes successfully!");
	}
}
