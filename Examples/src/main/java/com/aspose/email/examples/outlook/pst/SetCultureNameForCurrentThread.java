package com.aspose.email.examples.outlook.pst;

import com.aspose.email.*;
import com.aspose.email.examples.Utils;

import java.util.Locale;

public class SetCultureNameForCurrentThread {
	
	public static String dataDir = Utils.getSharedDataDir(SetCultureNameForCurrentThread.class) + "outlook/";
	
	public static void main(String[] args) {
		//ExStart: 1
		Locale defaultLocale = Locale.getDefault();
		try {
			// set incorrect default Locale
			Locale.setDefault(new Locale("en", "RU"));
			// set Current Thread Locale
			CurrentThreadSettings.setLocale("en-US");
			// or
			//CurrentThreadSettings.setLocale(new Locale("en", "US"));

			PersonalStorage.create(dataDir + "test.pst", FileFormatVersion.Unicode);
		} finally {
			Locale.setDefault(defaultLocale);
		}
		//ExEnd: 1
	}

}
