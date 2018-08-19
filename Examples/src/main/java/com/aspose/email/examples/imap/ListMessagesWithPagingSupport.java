package com.aspose.email.examples.imap;

import com.aspose.email.ImapClient;
import com.aspose.email.ImapPageInfo;
import com.aspose.email.PageSettings;
import com.aspose.email.SecurityOptions;
import com.aspose.email.system.IDisposable;
import com.aspose.email.system.collections.generic.List;

public class ListMessagesWithPagingSupport {

	public static void main(String[] args) {
		// Initiate ImapClient with account's user name and password
		ImapClient client = new ImapClient("server.domain.com", 587, "username", "password");
		// Set security options
		client.setSecurityOptions(SecurityOptions.Auto);
		try {
			// Number of items per page
			int itemsPerPage = 5;
			List<ImapPageInfo> pages = new List<ImapPageInfo>();
			PageSettings pageSettings = new PageSettings();
			ImapPageInfo pageInfo = client.listMessagesByPage(itemsPerPage, 0, pageSettings);

			pages.addItem(pageInfo);

			while (!pageInfo.getLastPage()) {
				 pageInfo = client.listMessagesByPage(itemsPerPage, pageInfo.getNextPage().getPageOffset(), pageSettings);
			}

			//Verify the count of retrieved items
			int retrievedItems = 0;

			for (ImapPageInfo folderCol : (Iterable<ImapPageInfo>) pages)
				retrievedItems += folderCol.getItems().size();

			System.out.println("Items retrieved: " + retrievedItems);
		} finally {
			if (client != null)
				((IDisposable) client).dispose();
		}

	}

}
