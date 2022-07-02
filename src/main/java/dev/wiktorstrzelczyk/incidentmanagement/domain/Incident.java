package dev.wiktorstrzelczyk.incidentmanagement.domain;

public final class Incident {
    private final Asset asset;
    private final DateRange period;
    private final IncidentSeverity severity;

    public Incident(Asset asset, DateRange period, IncidentSeverity severity) {
        this.asset = asset;
        this.period = period;
        this.severity = severity;
    }
}
