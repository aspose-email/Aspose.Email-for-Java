package com.aspose.email.examples.imap;

import com.aspose.email.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImapFetchGroupMessages {

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
		System.out.println("ListMessages Count: " + messageInfoCol.size());

		List<Integer> sequenceNumberList = new ArrayList<>();

		for(ImapMessageInfo messageInfo : messageInfoCol){
			sequenceNumberList.add(messageInfo.getSequenceNumber());
		}

		List<String> uniqueIdList = new ArrayList<>();

		for(ImapMessageInfo messageInfo : messageInfoCol){
			uniqueIdList.add(messageInfo.getUniqueId());
		}

		List<MailMessage> fetchedMessagesBySNumMC = (List<MailMessage>) imapClient.fetchMessagesBySequences(sequenceNumberList);
		System.out.println("fetchMessagesBySequences Count: " + fetchedMessagesBySNumMC.size());

		List<MailMessage> fetchedMessagesByUidMC = (List<MailMessage>) imapClient.fetchMessagesByUids(uniqueIdList);
		System.out.println("fetchMessagesByUids Count: " + fetchedMessagesByUidMC.size());
		//ExEnd: 1

		System.out.println("ImapFetchGroupMessages executed successfully.");
	}
}
