package com.aspose.email.examples.thunderbird;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aspose.email.MailMessage;
import com.aspose.email.MboxrdStorageReader;
import com.aspose.email.examples.Utils;

public class GetCurrentMessageSize {

	public static String dataDir = Utils.getSharedDataDir(GetMarkersInformation.class) + "Thunderbird/";
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		getCurrentMessageSize();
	}
	
	public static void getCurrentMessageSize() throws FileNotFoundException
	{
		//ExStart: GetCurrentMessageSize
		FileInputStream stream = new FileInputStream(dataDir + "ExampleMbox.mbox");
		MboxrdStorageReader reader = new MboxrdStorageReader(stream, false);

		MailMessage msg = null;
		while ((msg = reader.readNextMessage()) != null)
		{
		    long currentDataSize = reader.getCurrentDataSize();		//returns the number of bytes read

		    System.out.println("Bytes read: " + currentDataSize);
		    
		    msg.dispose();
		}
		//ExEnd: GetCurrentMessageSize
	}

}
