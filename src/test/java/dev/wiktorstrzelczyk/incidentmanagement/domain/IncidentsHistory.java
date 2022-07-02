package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class IncidentsHistoryTest {

    private final DateRange SAMPLE_INCIDENT_PERIOD = new DateRange(
            LocalDateTime.of(1, 2, 3, 4, 5, 6),
            LocalDateTime.of(1, 2, 3, 4, 5, 7)
    );

    @Test
    public void shouldFindTotalIndicentsPerAssetForTheDay() {
        // given
        IncidentsHistory incidentsHistory = new IncidentsHistory(
                List.of(sampleIncident()),
                SAMPLE_INCIDENT_PERIOD
        );

        // when
        incidentsHistory

    }

    private Incident sampleIncident() {
        return new Incident(
                "CRM System",
                SAMPLE_INCIDENT_PERIOD,
                IncidentSeverity.ONE
        );
    }
}
