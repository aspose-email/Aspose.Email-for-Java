package com.aspose.email.examples.smtp;

import com.aspose.email.HttpProxy;
import com.aspose.email.MailMessage;
import com.aspose.email.SecurityOptions;
import com.aspose.email.SmtpClient;
import com.aspose.email.SocksProxy;
import com.aspose.email.SocksVersion;

public class SendEmailViaProxyServer {

	public static void main(String[] args) {
		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "username", "aspose1234");
		client.setSecurityOptions(SecurityOptions.Auto);

		String proxyAddress = "192.168.203.142"; // Proxy address
		int proxyPort = 1080; // Proxy port
		SocksProxy proxy = new SocksProxy(proxyAddress, proxyPort, SocksVersion.SocksV5);

		client.setProxy(proxy);
		client.send(new MailMessage("sender@domain.com", "receiver@domain.com", "Sending Email via proxy", 
				"Implement socks proxy protocol for versions 4, 4a, 5 (only Username/Password authentication)"));
	}
	
	public static void SendEmailViaHttpProxy()
	{
		//ExStart: SendEmailViaHttpProxy
		HttpProxy proxy = new HttpProxy("18.222.124.59", 8080);
		SmtpClient client = new SmtpClient("smtp.gmail.com", 587, "username", "aspose1234");
		
	    client.setProxy(proxy);
	    client.send(new MailMessage(
	        "from@domain.com",
	        "to@domain.com",
	        "Sending email via HTTP Proxy",
	        "Aspose.Email lets you send emails via Http Proxy."));
	    //ExEnd: SendEmailViaHttpProxy
	}
}
