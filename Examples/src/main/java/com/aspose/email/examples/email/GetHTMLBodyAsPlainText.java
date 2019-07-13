package com.aspose.email.examples.email;

import com.aspose.email.MailMessage;
import com.aspose.email.SaveOptions;
import com.aspose.email.examples.Utils;

/*
This project uses automatic dependency resolution feature of Maven to resolve Aspose.Email for Java API reference when the project is build. Please check https://maven.apache.org/what-is-maven.html for more information. If you do not wish to use Maven, you can manually download Aspose.Email for Java API from http://www.aspose.com/downloads, install it and then add its reference to this project. For any issues, questions or suggestions please feel free to contact us using http://www.aspose.com/community/forums/default.aspx
 */

public class GetHTMLBodyAsPlainText {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the File directory.
        String dataDir = Utils.getSharedDataDir(GetHTMLBodyAsPlainText.class) + "email/";

        MailMessage mail = MailMessage.load(dataDir + "HtmlWithUrlSample.eml");
        String body_with_url = mail.getHtmlBodyText(true);// body will contain URL
        String body_without_url = mail.getHtmlBodyText(false);// body will not contain URL

        System.out.println("Body with URL: " + body_with_url);
        System.out.println("Body without URL: " + body_without_url);
        // ExEnd:1
    }
}

