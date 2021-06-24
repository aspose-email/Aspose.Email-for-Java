![GitHub all releases](https://img.shields.io/github/downloads/aspose-email/Aspose.email-for-Java/total) ![GitHub](https://img.shields.io/github/license/aspose-email/Aspose.email-for-java)
# Java Email API

[Aspose.Email for Java](https://products.aspose.com/email/java) is a complete set of Email Processing APIs to create, read and manipulate emails from within your applications. It makes it easier to work with many Outlook email message formats such as MSG, EML, EMLX and MHT files without the need of installing Microsoft Outlook. It also enables you to manage message storage files - Personal Storage Files (PST), Offline Storage Files (OST) along with message sending and receiving capabilities. You can also read and extract Outlook PST file that can be saved to disk in MSG format.

Directory | Description
--------- | -----------
[Examples](https://github.com/aspose-email/Aspose.Email-for-Java/tree/master/Examples) | A collection of Java examples that help you learn the product features.
[Plugins](https://github.com/aspose-email/Aspose.Email-for-Java/tree/master/Plugins) | Plugins that will demonstrate one or more features of Aspose.Email for Java.

<p align="center">
  <a title="Download complete Aspose.Email for Java source code" href="https://github.com/asposeemail/Aspose_Email_Java/archive/master.zip">
    <img src="https://raw.githubusercontent.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

## Email API Features

- Create messages from scratch or load existing email files for editing.
- Create and Set contents of MIME messages.
- Extract contents from emails.
- Load and save [appointment in ICS format](https://docs.aspose.com/email/java/working-with-appointments/).
- Ability to connect to SMTP, POP3, IMAP, Exchange server.
- Works with Thunderbird, Zimbra and IBM Notes.

## Read & Write Email Formats

**Microsoft Outlook:** MSG, PST, OST, OFT\
**Email:** EML, EMLX, MBOX\
**Others:** ICS, VCF, HTML, MHTML

## Read Email Formats

**Mac Outlook:** OLM

## Supported Environments

- **Microsoft Windows:** Windows Desktop & Server (x86, x64)
- **macOS:** Mac OS X
- **Linux:** Ubuntu, OpenSUSE, CentOS, and others
- **Java Versions:** `J2SE 7.0 (1.7)`, `J2SE 8.0 (1.8)`

## Get Started with Aspose.Email for Java

Aspose hosts all Java APIs at the [Aspose Repository](https://repository.aspose.com/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-email). You can easily use Aspose.BarCode for Java API directly in your Maven projects with simple configurations. For the detailed instructions please visit [Installing Aspose.Email for Java from Maven Repository](https://docs.aspose.com/email/java/installation/) documentation page.

## Perform IMAP Message Backup Operation using Java

```java
ImapClient imapClient = new ImapClient();
imapClient.setHost("<HOST>");
imapClient.setPort(993);
imapClient.setUsername("<USERNAME>");
imapClient.setPassword("<PASSWORD>");
imapClient.setSupportedEncryption(EncryptionProtocols.Tls);
imapClient.setSecurityOptions(SecurityOptions.SSLImplicit);

ImapMailboxInfo mailboxInfo = imapClient.getMailboxInfo();

ImapFolderInfo info = imapClient.getFolderInfo(mailboxInfo.getInbox().getName());
ImapFolderInfoCollection infos = new ImapFolderInfoCollection();
infos.add(info);

imapClient.backup(infos, dataDir + "\\ImapBackup.pst", BackupOptions.None);
```

[Home](https://www.aspose.com/) | [Product Page](https://products.aspose.com/email/java) | [Docs](https://docs.aspose.com/email/java/) | [Demos](https://products.aspose.app/email/family) | [API Reference](https://apireference.aspose.com/email/java) | [Examples](https://github.com/aspose-email/Aspose.Email-for-Java) | [Blog](https://blog.aspose.com/category/email/) | [Search](https://search.aspose.com/) | [Free Support](https://forum.aspose.com/c/email) | [Temporary License](https://purchase.aspose.com/temporary-license)
