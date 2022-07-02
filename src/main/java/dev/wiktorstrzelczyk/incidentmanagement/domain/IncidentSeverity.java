package dev.wiktorstrzelczyk.incidentmanagement.domain;

public enum IncidentSeverity {

    ONE(1, 30),
    TWO(2, 10),
    THREE(3, 10);
    private final int level;
    public final int weight;

    IncidentSeverity(int level, int weight) {
        this.level = level;
        this.weight = weight;
    }
}
