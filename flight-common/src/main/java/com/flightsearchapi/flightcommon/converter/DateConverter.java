package com.flightsearchapi.flightcommon.converter;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class DateConverter {

    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        try {
            GregorianCalendar calendar = GregorianCalendar.from(localDateTime.atZone(ZoneId.systemDefault()));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (Exception e) {
            throw new RuntimeException("Date conversion error", e);
        }
    }

    public static LocalDateTime toLocalDateTime(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().toZonedDateTime().toLocalDateTime();
    }
}