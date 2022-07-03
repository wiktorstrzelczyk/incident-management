package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;
import java.util.List;

public interface IncidentRepository {

    Incidents occurredOn(LocalDate date);
    void save(List<Incident> incidents);
}
