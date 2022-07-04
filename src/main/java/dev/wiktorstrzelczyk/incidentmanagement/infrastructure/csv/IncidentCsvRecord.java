package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.csv;


import dev.wiktorstrzelczyk.incidentmanagement.domain.Asset;
import dev.wiktorstrzelczyk.incidentmanagement.domain.DateRange;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentSeverity;

import java.time.LocalDateTime;

class IncidentCsvRecord {
    final String assetName;
    final LocalDateTime startDate;
    final LocalDateTime endDate;
    final int severity;

    public IncidentCsvRecord(String assetName, LocalDateTime startDate, LocalDateTime endDate, int severity) {
        this.assetName = assetName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.severity = severity;
    }

    Incident toDomain() {
        return new Incident(
                new Asset(assetName),
                new DateRange(
                        startDate,
                        endDate
                ),
                IncidentSeverity.fromInt(severity)
        );
    }
}
