package com.aspose.email.examples.email;

import java.util.ArrayList;
import java.util.List;

import com.aspose.email.Appointment;
import com.aspose.email.AppointmentLoadOptions;
import com.aspose.email.CalendarReader;
import com.aspose.email.examples.Utils;


public class ReadMultipleEventsfromICSFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReadMultipleEventsfromICSFile();
	}
	
	public static void ReadMultipleEventsfromICSFile()
	{
		//ExStart: ReadMultipleEventsfromICSFile
		String dataDir = Utils.getSharedDataDir(DisplayEmailInformation.class) + "email/";
		List<Appointment> appointments = new ArrayList<Appointment>();
		CalendarReader reader = new CalendarReader(dataDir + "US-Holidays.ics");
		while (reader.nextEvent())
		{
		    appointments.add(reader.getCurrent());
		}
		
		System.out.println("Number of events read: " + appointments.size());
		//Process appointments loaded from events

		//Reading events from a specific index
		appointments = new ArrayList<Appointment>();
		AppointmentLoadOptions options = new AppointmentLoadOptions();
		options.setEventIndex(4);
		reader = new CalendarReader(dataDir + "US-Holidays.ics", options);
		//start reading from 4th appointment...
		while (reader.nextEvent())
		{
		    appointments.add(reader.getCurrent());
		}
		//ExEnd: ReadMultipleEventsfromICSFile
	}

}
