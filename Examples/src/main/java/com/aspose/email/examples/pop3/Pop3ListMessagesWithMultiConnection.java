package com.aspose.email.examples.pop3;

import com.aspose.email.*;

import java.util.ArrayList;
import java.util.List;

public class Pop3ListMessagesWithMultiConnection {

	public static void main(String[] args) {
		//ExStart:1
		// Create an instance of the Pop3Client class
		Pop3Client pop3Client = new Pop3Client();
		pop3Client.setHost("<HOST>");
		pop3Client.setPort(995);
		pop3Client.setUsername("<USERNAME>");
		pop3Client.setPassword("<PASSWORD>");

		pop3Client.setConnectionsQuantity(5);
		pop3Client.setUseMultyConnection(MultyConnectionMode.Enable);
		long multiConnectionModeStartTime = System.nanoTime();
		Pop3MessageInfoCollection messageInfoCol1 = pop3Client.listMessages();
		long multiConnectionModeTimeSpan = System.nanoTime() - multiConnectionModeStartTime;

		pop3Client.setUseMultyConnection(MultyConnectionMode.Disable);
		long singleConnectionModeStartTime = System.nanoTime();
		Pop3MessageInfoCollection messageInfoCol2 = pop3Client.listMessages();
		long singleConnectionModeTimeSpan = System.nanoTime() - singleConnectionModeStartTime;

		double performanceRelation = (double)singleConnectionModeTimeSpan / (double)multiConnectionModeTimeSpan;
		System.out.println("Performance Relation: " + performanceRelation);
		//ExEnd: 1

		System.out.println("Pop3ListMessagesWithMultiConnection executed successfully.");
	}

}
