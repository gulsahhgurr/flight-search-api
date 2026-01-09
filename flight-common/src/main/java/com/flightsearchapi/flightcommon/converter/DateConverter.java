package com.flightsearchapi.flightcommon.converter;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class DateConverter {

    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        try {
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            localDateTime.getYear(),
                            localDateTime.getMonthValue(),
                            localDateTime.getDayOfMonth(),
                            0, 0, 0, 0,  // saat, dakika, saniye, milisaniye
                            DatatypeConstants.FIELD_UNDEFINED  // timezone
                    );
        } catch (Exception e) {
            throw new RuntimeException("Date conversion error: " + e.getMessage(), e);
        }
    }

    public static LocalDateTime toLocalDateTime(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }
}