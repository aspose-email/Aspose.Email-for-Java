package com.aspose.email.examples.exchangeews;

import java.util.concurrent.atomic.AtomicInteger;

import com.aspose.email.BeforeItemCallback;
import com.aspose.email.EWSClient;
import com.aspose.email.IEWSClient;
import com.aspose.email.ItemCallbackArgs;
import com.aspose.email.PersonalStorage;
import com.aspose.email.RestoreSettings;



public class AbortPSTToExchangeServerOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ExStart: AbortPSTToExchangeServerOperation
		PersonalStorage pst = PersonalStorage.fromFile("");
		
		IEWSClient client = EWSClient.getEWSClient("https://exchange.domain.com", "username", "password");
		
		final AtomicInteger numberOfProcessedItems = new AtomicInteger(0);

		RestoreSettings rs  = new RestoreSettings();
		
		rs.setBeforeItemCallback(new BeforeItemCallback() {
		    public void invoke(ItemCallbackArgs item) {
		        if (numberOfProcessedItems.get() >= 1)
		        {
		            throw new AbortRestoreException();
		        }

		        numberOfProcessedItems.incrementAndGet();
		    }
		});

		try {
		    client.restore(pst, rs);
		} catch (AbortRestoreException e) {
		    System.out.println("1 resored");
		}
		//ExEnd: AbortPSTToExchangeServerOperation
	}
}

