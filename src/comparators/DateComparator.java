package comparators;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate d1, LocalDate d2) {
        return d1.compareTo(d2);
    }
}