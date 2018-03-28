package com.aspose.email.examples.appointment;

import java.util.Date;

import com.aspose.email.Appointment;
import com.aspose.email.MailAddress;
import com.aspose.email.MailAddressCollection;
import com.aspose.email.ParticipationStatus;
import com.aspose.email.system.DateTime;

public class WorkingWithAppointments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetParticipantStatusOfAppointmentAttendees();
		
		System.out.println("Done..");
	}

	public static void SetParticipantStatusOfAppointmentAttendees()
	{
		//ExStart: SetParticipantStatusOfAppointmentAttendees
		String location = "Room 5";
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.set(2011, 11, 10, 10, 12, 11);
		Date startDate = c.getTime();
		c.set(2012, 10, 13, 13, 11, 12);
		Date endDate = c.getTime();
		MailAddress organizer = new MailAddress("aaa@amail.com", "Organizer");
		MailAddressCollection attendees = new MailAddressCollection();
		MailAddress attendee1 = new MailAddress("bbb@bmail.com", "First attendee");
		MailAddress attendee2 = new MailAddress("ccc@cmail.com", "Second attendee");

		attendee1.setParticipationStatus(ParticipationStatus.Accepted);
		attendee2.setParticipationStatus(ParticipationStatus.Declined);
		attendees.addMailAddress(attendee1);
		attendees.addMailAddress(attendee2);

		Appointment target = new Appointment(location, startDate, endDate, organizer, attendees);
		//ExEnd: SetParticipantStatusOfAppointmentAttendees
	}
}
