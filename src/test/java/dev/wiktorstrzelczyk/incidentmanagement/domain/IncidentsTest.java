package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.wiktorstrzelczyk.incidentmanagement.SampleData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IncidentsTest {

    @Test
    public void shouldCalculateIncidentsSummaryForOneIncident() {
        // given
        Incidents incidentsHistory = new Incidents(
                List.of(
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        )
                )
        );

        // when
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        CRM_SYSTEM_ASSET,
                                        1,
                                        1L,
                                        30L
                                )
                        )
                )
        );
    }

    @Test
    public void shouldCalculateIncidentsSummaryForSeveralIncidents() {
        // given
        Incidents incidentsHistory = new Incidents(
                List.of(
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        ),
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        ),
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        )
                )
        );

        // when
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        CRM_SYSTEM_ASSET,
                                        3,
                                        3L,
                                        90L
                                )
                        )
                )
        );
    }

    @Test
    public void shouldCalculateIncidentsSummaryForSeveralAssets() {
        // given
        Incidents incidentsHistory = new Incidents(
                List.of(
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        ),
                        new Incident(
                                SLACK_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        )
                )
        );

        // when
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        CRM_SYSTEM_ASSET,
                                        1,
                                        1L,
                                        30L
                                ),
                                new IncidentSummary(
                                        SLACK_ASSET,
                                        1,
                                        1L,
                                        30L
                                )
                        )
                )
        );
    }
    @Test
    public void shouldCorrectlyCalculateTotalDowntimeOfAsset() {
        // given
        Incidents incidentsHistory = new Incidents(
                List.of(
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        ),
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_HOUR_PERIOD,
                                IncidentSeverity.ONE
                        )
                )
        );

        // when
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        CRM_SYSTEM_ASSET,
                                        2,
                                        3601L,
                                        60L
                                )
                        )
                )
        );
    }

    @Test
    public void shouldCorrectlyCalculateRatingForAsset() {
        // given
        Incidents incidentsHistory = new Incidents(
                List.of(
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.ONE
                        ),
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.TWO
                        ),
                        new Incident(
                                CRM_SYSTEM_ASSET,
                                ONE_SECOND_PERIOD,
                                IncidentSeverity.THREE
                        )
                )
        );

        // when
        IncidentsSummary incidentsSummary = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummary).isEqualTo(
                new IncidentsSummary(
                        List.of(
                                new IncidentSummary(
                                        CRM_SYSTEM_ASSET,
                                        3,
                                        3L,
                                        50L
                                )
                        )
                )
        );
    }
}
