package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public final class IncidentsHistory {

    private final List<Incident> incidents;
    private final DateRange period;

    public IncidentsHistory(List<Incident> incidents, DateRange period) {
        this.incidents = incidents;
        this.period = period;
    }
}
