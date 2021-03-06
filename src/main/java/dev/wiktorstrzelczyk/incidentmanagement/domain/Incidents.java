package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Incidents {

    private final List<Incident> incidents;

    public Incidents(List<Incident> incidents) {
        this.incidents = new ArrayList<>(incidents);
    }

    public List<IncidentsStatisticalSummary> summary() {
        Set<Asset> assets = incidents.stream().map(incident -> incident.asset).collect(Collectors.toSet());
        return assets.stream().map(asset -> incidentSummaryFor(asset)).collect(Collectors.toList());
    }

    private IncidentsStatisticalSummary incidentSummaryFor(Asset asset) {
        List<Incident> incidents = getBy(asset);
        return new IncidentsStatisticalSummary(
                asset,
                incidents.size(),
                totalOfDowntimeInSecondsFor(incidents),
                ratingFor(incidents)
        );
    }

    private long totalOfDowntimeInSecondsFor(List<Incident> incidents) {
        return incidents.stream()
                .filter(incident -> incident.severity == IncidentSeverity.ONE)
                .map(incident -> incident.period.toSeconds())
                .reduce(0L, (subtotal, element) -> subtotal + element);
    }

    private long ratingFor(List<Incident> incidents) {
        return incidents.stream()
                .map(incident -> incident.severity.weight)
                .reduce(0, (subtotal, element) -> subtotal + element);
    }

    private List<Incident> getBy(Asset asset) {
        return incidents.stream()
                .filter(incident -> incident.asset.equals(asset))
                .collect(Collectors.toList());
    }
}
