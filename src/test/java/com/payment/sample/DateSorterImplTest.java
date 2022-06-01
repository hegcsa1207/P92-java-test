package com.payment.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

class DateSorterImplTest {

    @Test
    public void givenTwoDates_whenMonth1WithRAndMonth2WithoutR_thenReturnDate1First() {
        LocalDate date1 = LocalDate.of(2022, 12, 1);
        LocalDate date2 = LocalDate.of(2022, 5, 1);
        Set<LocalDate> unsortedDates = Set.of(date1, date2);

        DateSorterImpl dateSorter = new DateSorterImpl();
        SortedSet<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        LocalDate actualDate = sortedDates.first();

        Assertions.assertEquals(date1, actualDate);
    }

    @Test
    public void givenTwoDates_whenMonth1WithoutRAndMonth2WithR_thenReturnDate2First() {
        LocalDate date1 = LocalDate.of(2022, 5, 1);
        LocalDate date2 = LocalDate.of(2022, 12, 1);
        Set<LocalDate> unsortedDates = Set.of(date1, date2);

        DateSorterImpl dateSorter = new DateSorterImpl();
        SortedSet<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        LocalDate actualDate = sortedDates.first();

        Assertions.assertEquals(date2, actualDate);
    }

    @Test
    public void givenTwoDates_whenBothMonthWithRAndDate1Earlier_thenReturnDate1First() {
        LocalDate date1 = LocalDate.of(2022, 1, 1);
        LocalDate date2 = LocalDate.of(2022, 2, 1);
        Set<LocalDate> unsortedDates = Set.of(date1, date2);

        DateSorterImpl dateSorter = new DateSorterImpl();
        SortedSet<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        LocalDate actualDate = sortedDates.first();

        Assertions.assertEquals(date1, actualDate);
    }

    @Test
    public void givenTwoDates_whenBothMonthWithoutRAndDate1Earlier_thenReturnDate2First() {
        LocalDate date1 = LocalDate.of(2022, 5, 1);
        LocalDate date2 = LocalDate.of(2022, 6, 1);
        Set<LocalDate> unsortedDates = Set.of(date1, date2);

        DateSorterImpl dateSorter = new DateSorterImpl();
        SortedSet<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        LocalDate actualDate = sortedDates.first();

        Assertions.assertEquals(date2, actualDate);
    }
}