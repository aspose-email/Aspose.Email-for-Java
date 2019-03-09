package com.aspose.email.examples.exchangeews;

import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeMessageInfo;
import com.aspose.email.ExchangeMessageInfoCollection;
import com.aspose.email.IEWSClient;
import com.aspose.email.system.NetworkCredential;

import java.util.concurrent.atomic.AtomicInteger;

public class MoveItemsToInPlaceArchive {

    public static void main(String[] args) {
        //ExStart: MoveItemsToInPlaceArchive
        String mailboxUri = "<HOST>";
        String domain = "";
        String username = "<USERNAME>";
        String password = "<PASSWORD>";
        NetworkCredential credentials = new NetworkCredential(username, password, domain);
        IEWSClient client = EWSClient.getEWSClient(mailboxUri, credentials);

        ExchangeMessageInfoCollection msgCollection = client.listMessages(client.getMailboxInfo().getInboxUri());

        for (ExchangeMessageInfo msgInfo : msgCollection)
        {
            System.out.println("Subject:" + msgInfo.getSubject());
            client.archiveItem(client.getMailboxInfo().getInboxUri(), msgInfo.getUniqueUri());
        }
        client.dispose();
        //ExEnd: MoveItemsToInPlaceArchive
    }
}

