package com.aspose.email.examples.exchangeews;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.aspose.email.Appointment;
import com.aspose.email.EWSClient;
import com.aspose.email.ExchangeQueryBuilder;
import com.aspose.email.IEWSClient;
import com.aspose.email.MailQuery;

public class FilterAppointmentsUsingEWS {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		FilterAppointmentsByDateUsingEWS();
		
		FilterAppointmentsByRecurrenceUsingEWS();
	}

	public static void FilterAppointmentsByDateUsingEWS() throws ParseException
	{
		String mailboxUri = "";
		String username = "";
		String password = "";
		String domain = "";
		//ExStart: FilterAppointmentsByDateUsingEWS
		IEWSClient client = EWSClient.getEWSClient(mailboxUri, username, password, domain);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		ExchangeQueryBuilder builder = new ExchangeQueryBuilder();
		builder.getAppointment().getStart().since(sdf.parse("10/05/2016 10:00:00"));
		builder.getAppointment().getEnd().beforeOrEqual(sdf.parse("10/15/2016 10:00:00"));
		MailQuery query = builder.getQuery();
		Appointment[] appointments = client.listAppointments(query);
		//ExEnd: FilterAppointmentsByDateUsingEWS
	}
	
	public static void FilterAppointmentsByRecurrenceUsingEWS()
	{
		String mailboxUri = "";
		String username = "";
		String password = "";
		String domain = "";
		
		IEWSClient client = EWSClient.getEWSClient(mailboxUri, username, password, domain);
		ExchangeQueryBuilder builder = new ExchangeQueryBuilder();
		//ExStart: FilterAppointmentsByRecurrenceUsingEWS
		builder = new ExchangeQueryBuilder();
		builder.getAppointment().isRecurring().equals(false);
		MailQuery query = builder.getQuery();
		Appointment[]appointments = client.listAppointments(query);
		//ExEnd: FilterAppointmentsByRecurrenceUsingEWS
	}
}
