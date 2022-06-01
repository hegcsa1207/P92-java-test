package com.payment.sample;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

/**
 * The {@link DateSorterImpl} class. Implementation of {@link DateSorter} interface.
 */
public class DateSorterImpl implements DateSorter {

    /**
     * This method sorts dates in the following order:
     * Dates with an 'r' in the month, sorted ascending
     * (first to last),
     * then dates without an 'r' in the month, sorted descending
     * (last to first).
     *
     * @param unsortedDates - an unsorted list of dates
     * @return sor
     */
    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        SortedSet<LocalDate> sortedDates = new TreeSet<>(new LocalDateComparator());
        sortedDates.addAll(unsortedDates);
        return sortedDates;
    }

    private static class LocalDateComparator implements Comparator<LocalDate> {

        /**
         * This method compares two instances of {@link LocalDate} class
         * and returns a negative integer, zero, or a positive integer as
         * the first argument is less than, equal to, or greater than the second.
         *
         * @param date1 the first object to be compared.
         * @param date2 the second object to be compared.
         * @return int -1 if date1 has month with 'r' and date2 has month without 'r'
         *                  or if date1 is earlier than date2 and both have month with 'r'
         *              1 if date1 has month without 'r' and date2 has month with 'r'
         *                  or if date1 is earlier than date2 and both have month without 'r'
         *              0 if date1 and date2 are equal
         */
        @Override
        public int compare(LocalDate date1, LocalDate date2) {
            int result;
            boolean month1WithR = isMonthWithR(date1.getMonth());
            boolean month2WithR = isMonthWithR(date2.getMonth());
            if (month1WithR && !month2WithR) {
                result = -1;
            } else if (!month1WithR && month2WithR) {
                result = 1;
            } else {
                result = date1.compareTo(date2);
                result = month1WithR ? result : Math.negateExact(result);
            }
            return result;
        }

        private boolean isMonthWithR(Month month) {
            String monthDisplayName = month.getDisplayName(TextStyle.FULL, Locale.getDefault());
            return monthDisplayName.toLowerCase().contains("r");
        }
    }
}
