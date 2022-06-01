import com.payment.sample.DateSorterImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        Set<LocalDate> unsortedDates = Set.of(LocalDate.of(2019, 7, 1),
                LocalDate.of(2019, 1, 2),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 5, 3));

        Set<LocalDate> unsortedDates2 = Set.of(LocalDate.of(2022, 12, 1),
                LocalDate.of(2022, 12, 2),
                LocalDate.of(2019, 12, 3),
                LocalDate.of(2022, 1, 10),
                LocalDate.of(2022, 5, 15),
                LocalDate.of(2022, 7, 1),
                LocalDate.of(2022, 9, 1),
                LocalDate.of(2022, 8, 11),
                LocalDate.of(2022, 6, 20));

        DateSorterImpl dateSorterP92 = new DateSorterImpl();
        SortedSet<LocalDate> sortedDates = dateSorterP92.sortDates(unsortedDates2);
        System.out.print("Unsorted dates: ");
        unsortedDates2.stream().map(formatter::format).forEach(date -> System.out.print(date + " "));
        System.out.println();
        System.out.print("Sorted dates: ");
        sortedDates.stream().map(formatter::format).forEach(date -> System.out.print(date + " "));
    }
}