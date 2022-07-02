package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDateTime;

public class DateRange {
    public final LocalDateTime start;
    public final LocalDateTime stop;

    public DateRange(LocalDateTime start, LocalDateTime stop) {
        this.start = start;
        this.stop = stop;
    }
}
