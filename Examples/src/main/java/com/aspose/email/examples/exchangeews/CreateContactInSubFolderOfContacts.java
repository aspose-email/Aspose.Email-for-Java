package com.aspose.email.examples.exchangeews;

import com.aspose.email.Contact;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeFolderInfo;
import com.aspose.email.ExchangeFolderType;
import com.aspose.email.IEWSClient;
import com.aspose.email.MapiContact;

public class CreateContactInSubFolderOfContacts {
	public static void main(String[] args) {
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx", "username", "password", "domain.com");
		ExchangeFolderInfo folderInfo = client.createFolder("myfolder", ExchangeFolderType.Contact);
		client.createContact(folderInfo.getUri(), new MapiContact("MapiContact", "foo@gmail.com"));
		Contact contact = new Contact();
		contact.setDisplayName("Contact");
		client.createContact(folderInfo.getUri(), contact);
		MapiContact[] myfolderContacts = client.listContacts(folderInfo.getUri());
	}
}
