package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;

public interface IncidentRepository {
    
    Incidents with(LocalDate date);
}