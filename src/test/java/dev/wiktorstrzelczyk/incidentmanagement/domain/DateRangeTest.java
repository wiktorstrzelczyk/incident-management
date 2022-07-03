package dev.wiktorstrzelczyk.incidentmanagement.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DateRangeTest {

    @Test
    public void calculates_difference_between_dates_in_seconds() {
        // given
        DateRange dateRange = new DateRange(
                LocalDateTime.of(1, 1, 1, 1, 1, 1),
                LocalDateTime.of(2, 2, 2, 2, 2, 2)
        );

        // when
        long secondsBetweenDates = dateRange.toSeconds();

        // then
        assertThat(secondsBetweenDates).isEqualTo(34304461);
    }
}
