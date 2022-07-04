package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.summary;

import dev.wiktorstrzelczyk.incidentmanagement.domain.Asset;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
final class IncidentsStatisticalSummaryDocument {

    @Id
    final String id;
    final String assetName;
    final int totalIncidents;
    final long totalDowntimeInSeconds;
    final long rating;
    final LocalDate date;

    public IncidentsStatisticalSummaryDocument(String id, String assetName, int totalIncidents, long totalDowntimeInSeconds, long rating, LocalDate date) {
        this.id = id;
        this.assetName = assetName;
        this.totalIncidents = totalIncidents;
        this.totalDowntimeInSeconds = totalDowntimeInSeconds;
        this.rating = rating;
        this.date = date;
    }

    IncidentsStatisticalSummary toDomain() {
        return new IncidentsStatisticalSummary(
                new Asset(assetName),
                totalIncidents,
                totalDowntimeInSeconds,
                rating
        );
    }

    static IncidentsStatisticalSummaryDocument fromDomain(IncidentsStatisticalSummary domain, LocalDate date) {
        return new IncidentsStatisticalSummaryDocument(
                null,
                domain.asset.name,
                domain.totalIncidents,
                domain.totalDowntimeInSeconds,
                domain.rating,
                date
        );
    }
}

