package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.util.List;
import java.util.Objects;

public final class IncidentsSummary {

    public final List<IncidentSummary> incidentsSummaries;

    public IncidentsSummary(List<IncidentSummary> incidentsSummaries) {
        this.incidentsSummaries = incidentsSummaries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentsSummary that = (IncidentsSummary) o;
        return Objects.equals(incidentsSummaries, that.incidentsSummaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incidentsSummaries);
    }

    @Override
    public String toString() {
        return "IncidentsSummary{" +
                "incidentsSummaries=" + incidentsSummaries +
                '}';
    }
}
