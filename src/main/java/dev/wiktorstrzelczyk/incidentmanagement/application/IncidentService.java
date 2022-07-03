package dev.wiktorstrzelczyk.incidentmanagement.application;

import dev.wiktorstrzelczyk.incidentmanagement.domain.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final IncidentsStatisticalSummaryRepository incidentsStatisticalSummaryRepository;
    private final IncidentsFromInputStreamReader incidentsFromInputStreamReader;

    public IncidentService(
            IncidentRepository incidents,
            IncidentsStatisticalSummaryRepository incidentsStatisticalSummaryRepository,
            IncidentsFromInputStreamReader incidentsFromInputStreamReader
    ) {
        this.incidentRepository = incidents;
        this.incidentsStatisticalSummaryRepository = incidentsStatisticalSummaryRepository;
        this.incidentsFromInputStreamReader = incidentsFromInputStreamReader;
    }

    public void calculateStatisticalSummaryFor(LocalDate date) {
        Incidents dailyIncidents = incidentRepository.occurredOn(date);
        List<IncidentsStatisticalSummary> incidentSummaries = dailyIncidents.summary();
        incidentsStatisticalSummaryRepository.saveForDate(date, incidentSummaries);
    }

    public List<IncidentsStatisticalSummary> getStatisticalSummaryFor(LocalDate date) {
        return incidentsStatisticalSummaryRepository.forDay(date);
    }

    public void addIncidents(InputStream inputStream) {
        List<Incident> incidents = incidentsFromInputStreamReader.readFrom(inputStream);
        incidentRepository.save(incidents);
    }
}
