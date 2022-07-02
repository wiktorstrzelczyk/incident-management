package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.util.Map;

public final class IncidentsSummary {

    private final Map<String, Long> totalIncidents;
    private final Map<String, Long> totalDowntime;
    private final Map<String, Long> rating;

    public IncidentsSummary(Map<String, Long> totalIncidents, Map<String, Long> totalDowntime, Map<String, Long> rating) {
        this.totalIncidents = totalIncidents;
        this.totalDowntime = totalDowntime;
        this.rating = rating;
    }
}
