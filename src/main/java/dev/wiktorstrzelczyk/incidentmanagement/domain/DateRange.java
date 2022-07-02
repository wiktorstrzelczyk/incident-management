package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DateRange {
    public final LocalDateTime start;
    public final LocalDateTime stop;

    public DateRange(LocalDateTime start, LocalDateTime stop) {
        this.start = start;
        this.stop = stop;
    }

    public long toSeconds() {
        return ChronoUnit.SECONDS.between(start, stop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateRange dateRange = (DateRange) o;
        return Objects.equals(start, dateRange.start) && Objects.equals(stop, dateRange.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, stop);
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "start=" + start +
                ", stop=" + stop +
                '}';
    }
}
