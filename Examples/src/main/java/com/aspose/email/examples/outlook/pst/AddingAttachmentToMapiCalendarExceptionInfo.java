package com.aspose.email.examples.outlook.pst;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;

import com.aspose.email.FileFormatVersion;
import com.aspose.email.FolderInfo;
import com.aspose.email.MapiAttachmentCollection;
import com.aspose.email.MapiCalendar;
import com.aspose.email.MapiCalendarDailyRecurrencePattern;
import com.aspose.email.MapiCalendarEventRecurrence;
import com.aspose.email.MapiCalendarExceptionInfo;
import com.aspose.email.MapiCalendarRecurrenceEndType;
import com.aspose.email.MapiCalendarRecurrencePattern;
import com.aspose.email.MapiCalendarRecurrencePatternType;
import com.aspose.email.PersonalStorage;
import com.aspose.email.StandardIpmFolder;

public class AddingAttachmentToMapiCalendarExceptionInfo {
	
	public static void main(String[] args) {
		Date startDate = addHours(newDate(2018, 7, 19), 12);
		MapiCalendar calendar = new MapiCalendar("location1", "summary1", "description1", startDate, addHours(startDate, 1));

		MapiCalendarEventRecurrence recurrence = new MapiCalendarEventRecurrence();
		recurrence.setRecurrencePattern(new MapiCalendarDailyRecurrencePattern());
		MapiCalendarRecurrencePattern pattern = recurrence.getRecurrencePattern(); 
		pattern.setPatternType(MapiCalendarRecurrencePatternType.Day);
		pattern.setPeriod(1);
		pattern.setEndType(MapiCalendarRecurrenceEndType.NeverEnd);

		Date exceptionDate = addDays(startDate, 3);
		MapiCalendarExceptionInfo exception = new MapiCalendarExceptionInfo();
		exception.setLocation("exceptionLocation");
		exception.setSubject("exceptionSubject");
		exception.setBody("exceptionBody");
		exception.setOriginalStartDate(exceptionDate);
		exception.setStartDateTime(exceptionDate);
		exception.setEndDateTime(addHours(exceptionDate, 5));
		exception.setAttachments(new MapiAttachmentCollection(calendar));
		exception.getAttachments().add("file.txt", new String("hello, world!").getBytes());

		pattern.getExceptions().addItem(exception);
		pattern.getModifiedInstanceDates().addItem(exceptionDate);
		pattern.getDeletedInstanceDates().addItem(exceptionDate);
		calendar.setRecurrence(recurrence);

		final PersonalStorage newPst = PersonalStorage.create(new ByteArrayOutputStream(), FileFormatVersion.Unicode);
		try
		{
		    FolderInfo newFolder = newPst.createPredefinedFolder("Calendar", StandardIpmFolder.Appointments);
		    newFolder.addMapiMessageItem(calendar);
		}
		finally { newPst.dispose(); }
	}
			private static Date newDate(int y, int m, int d) {
			    java.util.Calendar c = java.util.Calendar.getInstance();
			    c.setTimeInMillis(0);
			    c.set(y,  m-1, d, 0, 0, 0);
			    return c.getTime();
			}
			private static Date addHours(Date date, int amount) {
			    Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.HOUR, amount);
			    return c.getTime();
			}
			private static Date addDays(Date date, int amount) {
			    Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.DAY_OF_MONTH, amount);
			    return c.getTime();
			}

}
