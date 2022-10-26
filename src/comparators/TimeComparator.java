package comparators;

import java.time.LocalTime;
import java.util.Comparator;

public class TimeComparator implements Comparator<LocalTime> {
    @Override
    public int compare(LocalTime t1, LocalTime t2) {
        return t1.compareTo(t2);
    }
}