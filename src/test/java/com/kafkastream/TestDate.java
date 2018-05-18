package com.kafkastream;

import java.util.*;

public class TestDate
{
    public static void main(String[]    args)
    {
   /*     Locale  locale=new Locale("en","us");
        System.out.println("locale.getDisplayCountry(): "+locale.getDisplayCountry());
        System.out.println("locale.getDisplayLanguage(): "+locale.getDisplayLanguage());
        System.out.println("locale.getISO3Country(): "+locale.getISO3Country());*/

        //Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("PST"));
        Calendar calendar=Calendar.getInstance(TimeZone.getDefault());
        System.out.println("calendar.getTimeZone(): "+calendar.getTimeZone());
        System.out.println("calendar.getTime(): "+calendar.getTime());
        System.out.println("date: "+calendar.get(Calendar.DATE));
        System.out.println("Calendar.MONTH: "+calendar.get(Calendar.MONTH));
        System.out.println("Calendar.YEAR: "+calendar.get(Calendar.YEAR));
        System.out.println("Calendar.DAY_OF_MONTH: "+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Calendar.HOUR_OF_DAY: "+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Calendar.MINUTE: "+calendar.get(Calendar.MINUTE));
        System.out.println("Calendar.SECOND: "+calendar.get(Calendar.SECOND));
        System.out.println("Calendar.MILLISECOND: "+calendar.get(Calendar.MILLISECOND));
        System.out.println("Calendar.AM_PM: "+calendar.get(Calendar.AM_PM));
        System.out.println("Calendar.AM_PM: "+calendar.getTimeZone().useDaylightTime());
    }
}
