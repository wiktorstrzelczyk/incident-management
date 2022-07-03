package dev.wiktorstrzelczyk.incidentmanagement.infrastructure;

import dev.wiktorstrzelczyk.incidentmanagement.application.IncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/statistical-summary")
    public void getStatisticalSummary(LocalDate date) {
        incidentService.getStatisticalSummaryFor(date);
    }

    @PostMapping
    public void addIncidents() {
    }
}
