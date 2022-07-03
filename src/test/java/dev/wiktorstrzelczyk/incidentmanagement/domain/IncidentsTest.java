package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.wiktorstrzelczyk.incidentmanagement.SampleData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IncidentsTest {

    @Test
    public void calculates_statistics_for_single_incident() {
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
        List<IncidentSummary> incidentsSummaries = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummaries).isEqualTo(
                List.of(
                        new IncidentSummary(
                                CRM_SYSTEM_ASSET,
                                1,
                                1L,
                                30L
                        )
                )
        );
    }

    @Test
    public void calculates_statistics_for_three_incidents() {
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
        List<IncidentSummary> incidentsSummaries = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummaries).isEqualTo(
                List.of(
                        new IncidentSummary(
                                CRM_SYSTEM_ASSET,
                                3,
                                3L,
                                90L
                        )
                )
        );
    }

    @Test
    public void calculates_statistics_for_two_different_assets() {
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
        List<IncidentSummary> incidentsSummaries = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummaries).isEqualTo(
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
        List<IncidentSummary> incidentsSummaries = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummaries).isEqualTo(
                List.of(
                        new IncidentSummary(
                                CRM_SYSTEM_ASSET,
                                2,
                                3601L,
                                60L
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
        List<IncidentSummary> incidentsSummaries = incidentsHistory.calculateSummary();

        // then
        assertThat(incidentsSummaries).isEqualTo(
                List.of(
                        new IncidentSummary(
                                CRM_SYSTEM_ASSET,
                                3,
                                3L,
                                50L
                        )
                )
        );
    }
}
