package com.aspose.email.examples.exchangeews;

import com.aspose.email.AutodiscoverService;
import com.aspose.email.CalendarWriter;
import com.aspose.email.UserSettingName;
import com.aspose.email.system.NetworkCredential;
import com.aspose.email.system.collections.generic.IGenericDictionary;

public class AutoDiscoverUsingEWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ExStart: AutoDiscoverUsingEWS
		String email = "...";
		String password = "...";
		AutodiscoverService svc = new AutodiscoverService();
		svc.setCredentials(new NetworkCredential("username@domain.com", "password"));

		IGenericDictionary<Integer,Object> userSettings = svc.getUserSettings(email, UserSettingName.ExternalEwsUrl).getSettings();
		String ewsUrl = (String)userSettings.get_Item(UserSettingName.ExternalEwsUrl);
		System.out.println("Exchange Server Url: " + ewsUrl);
		//ExEnd: AutoDiscoverUsingEWS
	}

}
