package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.incident;

import dev.wiktorstrzelczyk.incidentmanagement.domain.Asset;
import dev.wiktorstrzelczyk.incidentmanagement.domain.DateRange;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentSeverity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
final class IncidentDocument {

    @Id
    String id;
    String assetName;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int severity;

    public IncidentDocument(String id, String assetName, LocalDateTime startDate, LocalDateTime endDate, int severity) {
        this.id = id;
        this.assetName = assetName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.severity = severity;
    }

    public Incident toDomain() {
        return new Incident(
                new Asset(assetName),
                new DateRange(
                        startDate,
                        endDate
                ),
                IncidentSeverity.from(severity)
        );
    }

    public static IncidentDocument fromDomain(Incident incident) {
        return new IncidentDocument(
                null,
                incident.asset.name,
                incident.period.start,
                incident.period.stop,
                incident.severity.toLevel()
        );
    }
}
