package dev.wiktorstrzelczyk.incidentmanagement.domain;


public final class IncidentSummary {
    public final Asset asset;
    public final Long totalIncidents;
    public  final Long totalDowntimeInSeconds;
    public final Long rating;

    public IncidentSummary(Asset asset, Long totalIncidents, Long totalDowntimeInSeconds, Long rating) {
        this.asset = asset;
        this.totalIncidents = totalIncidents;
        this.totalDowntimeInSeconds = totalDowntimeInSeconds;
        this.rating = rating;
    }
}
