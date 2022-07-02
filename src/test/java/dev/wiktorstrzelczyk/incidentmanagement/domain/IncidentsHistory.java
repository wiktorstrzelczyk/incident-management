package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        new Asset("CRM System"),
                                        1L,
                                        1L,
                                        30L
                                )
                        )
                )
        );
    }

    private Incident sampleIncident() {
        return new Incident(
                new Asset("CRM System"),
                SAMPLE_INCIDENT_PERIOD,
                IncidentSeverity.ONE
        );
    }
}
