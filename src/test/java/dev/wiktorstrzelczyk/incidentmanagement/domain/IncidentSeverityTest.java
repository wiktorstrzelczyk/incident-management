package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IncidentSeverityTest {

    @Test
    public void maps_1_to_severity_one() {
        // when
        IncidentSeverity incidentSeverity = IncidentSeverity.from(1);

        // then
        assertThat(incidentSeverity).isEqualTo(IncidentSeverity.ONE);
    }

    @Test
    public void maps_2_to_severity_two() {
        // when
        IncidentSeverity incidentSeverity = IncidentSeverity.from(2);

        // then
        assertThat(incidentSeverity).isEqualTo(IncidentSeverity.TWO);
    }

    @Test
    public void maps_3_to_severity_three() {
        // when
        IncidentSeverity incidentSeverity = IncidentSeverity.from(3);

        // then
        assertThat(incidentSeverity).isEqualTo(IncidentSeverity.THREE);
    }

    @Test
    @ValueSource(ints = {-1, 0, 4, 5})
    public void mapping_values_different_than_1_2_3_is_not_allowed() {
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            IncidentSeverity.from(4);
        });
    }
}
