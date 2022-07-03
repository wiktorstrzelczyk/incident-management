package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.csv;


import dev.wiktorstrzelczyk.incidentmanagement.domain.Asset;
import dev.wiktorstrzelczyk.incidentmanagement.domain.DateRange;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentSeverity;

import java.time.LocalDateTime;

class IncidentCsv {
    String id;
    String assetName;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int severity;

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
