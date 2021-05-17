package com.ss.may21.p5;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

/**
 * 1. Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
 *          LocalDateTime (without time zone) or ZonedDateTime (with time zone)
 *
 * 2. Given a random date, how would you find the date of the previous Thursday?
 *          Use TemporalAdjuster with previous
 *
 * 3. What is the difference between a ZoneId and a ZoneOffset?
 *          ZoneId gives a specific time zone identifier whereas ZoneOffset gives an
 *          offset in hours from UTC/Greenwich.
 *
 * 4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
 *          Instant -> ZonedDateTime use ZonedDateTime.ofInstant() or Instant.atZone()
 *          ZonedDateTime -> Instant use toInstant()
 *
 * 5. Write an example that, for a given year, reports the length of each month within that year.
 *
 * 6. Write an example that, for a given month of the current year, lists all of the Mondays in that month.
 *
 * 7. Write an example that tests whether a given date occurs on Friday the 13th.
 */

public class Main {

    public static void main(String[] args) {
        // store birthday in years, months, days, hours minutes, seconds, nanoseconds
//        LocalDateTime birthday = LocalDateTime
//                .of(2021,05,17,12,55,30,20);

        // given random date, find previous Thursday
        //LocalDate prevThurs = birthday.toLocalDate().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));

        // zoneid and zoneoffset
        //System.out.println("%nZoneId:%n" + ZoneId.getAvailableZoneIds().toString());

        // given year, report length of each month in that year
//        Integer year = 1990;
//        for (Month month : Month.values()) {
//            YearMonth ym = YearMonth.of(year, month);
//            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
//        }

        // given month of current year, list all Mondays in month
//        Month currMonth = Month.MAY;
//        LocalDate date = Year.now().atMonth(currMonth).atDay(1).
//                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
//        Month month = date.getMonth();
//        while (month == currMonth) {
//            System.out.println(date);
//            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//            month = date.getMonth();
//        }

        // tests whether a given date occurs on Friday the 13th
//        LocalDate givenDate = Year.now().atMonth(10).atDay(13);
//        System.out.println(givenDate + "\n" + ((givenDate.get(ChronoField.DAY_OF_MONTH) == 13) &&
//                (givenDate.get(ChronoField.DAY_OF_WEEK) == 5)));

    }
}
