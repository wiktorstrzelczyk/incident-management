package dev.wiktorstrzelczyk.incidentmanagement.domain;

public enum IncidentSeverity {
    ONE(30),
    TWO(10),
    THREE(10);
    public final int weight;

    IncidentSeverity(int weight) {
        this.weight = weight;
    }

    public static IncidentSeverity fromInt(int value) {
        switch(value) {
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            default: throw new IllegalArgumentException("Severity level should be a value from 1 to 3.");
        }
    }

    public int toInt() {
        switch(this) {
            case ONE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            default: throw new IllegalArgumentException("Severity level should be a value from 1 to 3.");
        }
    }
}
