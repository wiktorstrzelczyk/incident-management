package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
}
