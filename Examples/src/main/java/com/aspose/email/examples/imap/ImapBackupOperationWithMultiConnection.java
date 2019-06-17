package com.aspose.email.examples.imap;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class ImapBackupOperationWithMultiConnection {

	public static String dataDir = Utils.getSharedDataDir(ImapBackupOperationWithMultiConnection.class) + "IMAP/";

	public static void main(String[] args) {
		// ExStart:1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		imapClient.setUseMultiConnection(MultiConnectionMode.Enable);

		ImapMailboxInfo mailboxInfo = imapClient.getMailboxInfo();

		ImapFolderInfo info = imapClient.getFolderInfo(mailboxInfo.getInbox().getName());
		ImapFolderInfoCollection infos = new ImapFolderInfoCollection();
		infos.add(info);

		imapClient.backup(infos, dataDir + "\\ImapBackup.pst", BackupOptions.None);
		// ExEnd:1
	}
}
