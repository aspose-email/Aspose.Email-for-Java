package com.aspose.email.examples.email;

import com.aspose.email.HyperlinkRenderingCallback;
import com.aspose.email.MailMessage;
import com.aspose.email.examples.Utils;


public class CustomHyperlinkRendering {
    //ExStart: 1
	public static void main(String[] args) {
        String dataDir = Utils.getSharedDataDir(CustomHyperlinkRendering.class) + "email/";
		String fileName = dataDir + "LinksSample.eml";
		MailMessage msg = MailMessage.load(fileName);
		String htmlTextHref = msg.getHtmlBodyText(new HyperlinkRenderingCallback() {
			@Override
			public String invoke(String source) {
				return RenderHyperlinkWithHref(source);
			}
		});
		System.out.println(htmlTextHref);

		String htmlTextHrefLess = msg.getHtmlBodyText(new HyperlinkRenderingCallback() {
			@Override
			public String invoke(String source) {
				return RenderHyperlinkWithoutHref(source);
			}
		});
		System.out.println(htmlTextHrefLess);
	}

	private static String RenderHyperlinkWithHref(String source)
	{
		int start = source.indexOf("href=\"") + "href=\"".length();
		int end = source.indexOf("\"", start + "href=\"".length());
		String href = source.substring(start, end);
		start = source.indexOf(">") + 1;
		end = source.indexOf("<", start);
		String text = source.substring(start, end);
		String link = text + "<" + href + ">";
		return link;
	}

	private static String RenderHyperlinkWithoutHref(String source)
	{
		int start = source.indexOf(">") + 1;
		int end = source.indexOf("<", start);
		String text = source.substring(start, end);
		return text;
	}
    //ExEnd: 1
}
