package dev.wiktorstrzelczyk.incidentmanagement.domain;

public final class Incident {
    private final String assetName;
    private final DateRange period;
    private final IncidentSeverity severity;

    public Incident(String assetName, DateRange period, IncidentSeverity severity) {
        this.assetName = assetName;
        this.period = period;
        this.severity = severity;
    }
}
