package dev.wiktorstrzelczyk.incidentmanagement;

import dev.wiktorstrzelczyk.incidentmanagement.domain.Asset;
import dev.wiktorstrzelczyk.incidentmanagement.domain.DateRange;

import java.time.LocalDateTime;

public final class SampleData {

    public static final DateRange ONE_SECOND_PERIOD = new DateRange(
            LocalDateTime.of(1, 1, 1, 1, 1, 1),
            LocalDateTime.of(1, 1, 1, 1, 1, 2)
    );

    public static final DateRange ONE_HOUR_PERIOD = new DateRange(
            LocalDateTime.of(1, 1, 1, 1, 1, 1),
            LocalDateTime.of(1, 1, 1, 2, 1, 1)
    );

    public static final Asset CRM_SYSTEM_ASSET = new Asset("CRM System");
    public static final Asset JIRA_ASSET = new Asset("Jira");
    public static final Asset SLACK_ASSET = new Asset("Slack");

}
