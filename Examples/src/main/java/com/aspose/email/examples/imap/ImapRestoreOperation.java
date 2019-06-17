package com.aspose.email.examples.imap;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class ImapRestoreOperation {

	public static String dataDir = Utils.getSharedDataDir(ImapRestoreOperation.class) + "IMAP/";

	public static void main(String[] args) {
		// ExStart:1
		ImapClient imapClient = new ImapClient();
		imapClient.setHost("<HOST>");
		imapClient.setPort(993);
		imapClient.setUsername("<USERNAME>");
		imapClient.setPassword("<PASSWORD>");
		imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
		imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

		ImapRestoreSettings settings = new ImapRestoreSettings();
		settings.setRecursive(true);
		PersonalStorage pst = PersonalStorage.fromFile(dataDir + "\\ImapBackup.pst");
		imapClient.restore(pst, settings);
		// ExEnd:1
	}
}
