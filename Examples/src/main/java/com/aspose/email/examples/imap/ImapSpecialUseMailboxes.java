package com.aspose.email.examples.imap;

import com.aspose.email.*;

public class ImapSpecialUseMailboxes {

	public static void main(String[] args) {
		// ExStart:1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

        ImapMailboxInfo mailboxInfo = imapClient.getMailboxInfo();
        System.out.println(mailboxInfo.getInbox());
        System.out.println(mailboxInfo.getDraftMessages());
        System.out.println(mailboxInfo.getJunkMessages());
        System.out.println(mailboxInfo.getSentMessages());
        System.out.println(mailboxInfo.getTrash());
        //ExEnd: 1

        System.out.println("ImapSpecialUseMailboxes executed successfully.");
	}
}
