package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.time.LocalDate;
import java.util.List;

public interface IncidentsStatisticalSummaryRepository {

    List<IncidentsStatisticalSummary> forDay(LocalDate date);
    void save(List<IncidentsStatisticalSummary> incidentSummaries);
}
