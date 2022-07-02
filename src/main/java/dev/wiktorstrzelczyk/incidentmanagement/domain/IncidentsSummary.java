package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.util.List;

public final class IncidentsSummary {

    public final List<IncidentSummary> incidentsSummaries;

    public IncidentsSummary(List<IncidentSummary> incidentsSummaries) {
        this.incidentsSummaries = incidentsSummaries;
    }
}
