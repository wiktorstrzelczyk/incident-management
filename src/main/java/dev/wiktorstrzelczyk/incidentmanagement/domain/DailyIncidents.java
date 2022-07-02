package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class DailyIncidents {

    private final List<Incident> incidents;
    private final LocalDate date;

    public DailyIncidents(List<Incident> incidents, LocalDate date) {
        this.incidents = incidents;
        this.date = date;
    }
}
