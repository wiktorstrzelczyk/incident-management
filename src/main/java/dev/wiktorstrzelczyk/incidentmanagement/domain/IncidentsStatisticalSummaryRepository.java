package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;
import java.util.List;

public interface IncidentsStatisticalSummaryRepository {

    List<IncidentSummary> forDay(LocalDate date);
    void save(List<IncidentSummary> incidentSummaries);
}