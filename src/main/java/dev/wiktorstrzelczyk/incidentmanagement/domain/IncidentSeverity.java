package dev.wiktorstrzelczyk.incidentmanagement.domain;

public enum IncidentSeverity {

    ONE(1),
    TWO(2),
    THREE(3);
    private final Integer level;

    IncidentSeverity(Integer level) {
        this.level = level;
    }
}
