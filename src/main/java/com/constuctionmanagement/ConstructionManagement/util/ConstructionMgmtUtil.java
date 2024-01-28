package com.constuctionmanagement.ConstructionManagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConstructionMgmtUtil {
    public static Date getFromDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now().minusDays(localDateTime.getDayOfWeek().getValue());
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static Date getToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now().plusDays(7 - localDateTime.getDayOfWeek().getValue());
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
    public static Date getParsed(String fromDateString) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(fromDateString);
    }
}
