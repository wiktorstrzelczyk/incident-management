package dev.wiktorstrzelczyk.incidentmanagement.application;

import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentRepository;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentSummary;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incidents;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final IncidentsStatisticalSummaryRepository incidentsStatisticalSummaryRepository;

    public IncidentService(IncidentRepository incidents, IncidentsStatisticalSummaryRepository incidentsStatisticalSummaryRepository) {
        this.incidentRepository = incidents;
        this.incidentsStatisticalSummaryRepository = incidentsStatisticalSummaryRepository;
    }

    public void calculateStatisticalSummaryFor(LocalDate date) {
        Incidents dailyIncidents = incidentRepository.occurredOn(date);
        List<IncidentSummary> incidentSummaries = dailyIncidents.calculateSummary();
        incidentsStatisticalSummaryRepository.save(incidentSummaries);
    }
}
