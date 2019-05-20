package com.aspose.email.examples.pop3;

import com.aspose.email.*;

import java.util.ArrayList;
import java.util.List;

public class Pop3FetchGroupMessages {

	public static void main(String[] args) {
		//ExStart:1
		// Create an instance of the Pop3Client class
		Pop3Client pop3Client = new Pop3Client();
		pop3Client.setHost("<HOST>");
		pop3Client.setPort(995);
		pop3Client.setUsername("<USERNAME>");
		pop3Client.setPassword("<PASSWORD>");

		Pop3MessageInfoCollection messageInfoCol = pop3Client.listMessages();
		System.out.println("ListMessages Count: " + messageInfoCol.size());

		List<Integer> sequenceNumberList = new ArrayList<>();
		List<String> uniqueIdList = new ArrayList<>();

		for(Pop3MessageInfo messageInfo : messageInfoCol){
			sequenceNumberList.add(messageInfo.getSequenceNumber());
			uniqueIdList.add(messageInfo.getUniqueId());
		}

		List<MailMessage> fetchedMessagesBySNumMC = (List<MailMessage>) pop3Client.fetchMessagesBySequences(sequenceNumberList);
		System.out.println("fetchMessagesBySequences Count: " + fetchedMessagesBySNumMC.size());

		List<MailMessage> fetchedMessagesByUidMC = (List<MailMessage>) pop3Client.fetchMessagesByUids(uniqueIdList);
		System.out.println("fetchMessagesByUids Count: " + fetchedMessagesByUidMC.size());
		//ExEnd: 1

		System.out.println("Pop3FetchGroupMessages executed successfully.");
	}

}
