package com.aspose.email.examples.exchangeews;

import java.util.Arrays;
import java.util.UUID;

import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.KnownPropertySets;
import com.aspose.email.MapiMessage;
import com.aspose.email.PidNamePropertyDescriptor;
import com.aspose.email.PropertyDataType;
import com.aspose.email.PropertyDescriptor;

public class WorkingwithExchangeExtendedAttributesofMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com/exchangeews/Exchange.asmx/", "user", "password", "");
		//ExStart: WorkingwithExchangeExtendedAttributesofMessages
		 try
		    {
		        //Create a new Property
		        PidNamePropertyDescriptor pd = new PidNamePropertyDescriptor(
		            "MyTestProp",
		            PropertyDataType.String,
		            UUID.fromString("00020329-0000-0000-C000-000000000046"));
		        String value = "MyTestPropValue";

		        //Create a message
		        MapiMessage message = new MapiMessage(
		            "from@domain.com",
		            "to@domain.com",
		            "EMAILNET-38844 - " + UUID.randomUUID().toString(),
		            "EMAILNET-38844 EWS: Support for create, retrieve and update Extended Attributes for Emails");

		        //Set property on the message
		        message.setProperty(pd, value);

		        //append the message to server
		        String uri = client.appendMessage(message);

		        //Fetch the message from server
		        MapiMessage mapiMessage = client.fetchMapiMessage(uri, Arrays.asList(new PropertyDescriptor[] { pd }));
		        
		        //Retrieve the property from the message
		        String fetchedValue = mapiMessage.getNamedProperties().get_Item(pd).getString();
		    }
		    finally
		    {
		    }
		//ExEnd: WorkingwithExchangeExtendedAttributesofMessages
	}

}
