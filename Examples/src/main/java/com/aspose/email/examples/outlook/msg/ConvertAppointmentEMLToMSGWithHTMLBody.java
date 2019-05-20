package com.aspose.email.examples.outlook.msg;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

public class ConvertAppointmentEMLToMSGWithHTMLBody {

	public static void main(String[] args) {
		// ExStart:1
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(DistributionList.class) + "outlook/";


		MailMessage mailMessage = MailMessage.load(dataDir + "TestAppointment.eml");

		MapiConversionOptions conversionOptions = new MapiConversionOptions();
		conversionOptions.setFormat(OutlookMessageFormat.Unicode);

		// default value for ForcedRtfBodyForAppointment is true
		conversionOptions.setForcedRtfBodyForAppointment(false);

		MapiMessage mapiMessage = MapiMessage.fromMailMessage(mailMessage, conversionOptions);

		if(mapiMessage.getBodyType() == BodyContentType.Html){
			System.out.println("Body Type: Html");
		} else if(mapiMessage.getBodyType() == BodyContentType.Rtf){
			System.out.println("Body Type: Rtf");
		}

		mapiMessage.save(dataDir + "TestAppointment_out.msg");
		// ExEnd:1

		System.out.println("ConvertAppointmentEMLToMSGWithHTMLBody executed successfully.");
	}

}
