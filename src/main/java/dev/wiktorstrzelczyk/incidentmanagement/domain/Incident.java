package dev.wiktorstrzelczyk.incidentmanagement.domain;

public final class Incident {
    public final Asset asset;
    public final DateRange period;
    public final IncidentSeverity severity;

    public Incident(Asset asset, DateRange period, IncidentSeverity severity) {
        this.asset = asset;
        this.period = period;
        this.severity = severity;
    }
}
