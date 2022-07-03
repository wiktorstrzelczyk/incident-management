package dev.wiktorstrzelczyk.incidentmanagement.domain;


import java.time.LocalDate;
import java.util.List;

public interface IncidentsStatisticalSummaryRepository {

    List<IncidentsStatisticalSummary> forDay(LocalDate date);
    void saveForDate(LocalDate date, List<IncidentsStatisticalSummary> incidentSummaries);
}
