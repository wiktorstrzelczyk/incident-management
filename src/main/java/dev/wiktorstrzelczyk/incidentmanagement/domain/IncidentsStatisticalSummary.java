package dev.wiktorstrzelczyk.incidentmanagement.domain;


import java.util.Objects;

public final class IncidentsStatisticalSummary {
    public final Asset asset;
    public final int totalIncidents;
    public final long totalDowntimeInSeconds;
    public final long rating;

    public IncidentsStatisticalSummary(Asset asset, int totalIncidents, long totalDowntimeInSeconds, long rating) {
        this.asset = asset;
        this.totalIncidents = totalIncidents;
        this.totalDowntimeInSeconds = totalDowntimeInSeconds;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentsStatisticalSummary that = (IncidentsStatisticalSummary) o;
        return totalIncidents == that.totalIncidents && totalDowntimeInSeconds == that.totalDowntimeInSeconds && rating == that.rating && Objects.equals(asset, that.asset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asset, totalIncidents, totalDowntimeInSeconds, rating);
    }

    @Override
    public String toString() {
        return "IncidentSummary{" +
                "asset=" + asset +
                ", totalIncidents=" + totalIncidents +
                ", totalDowntimeInSeconds=" + totalDowntimeInSeconds +
                ", rating=" + rating +
                '}';
    }
}
