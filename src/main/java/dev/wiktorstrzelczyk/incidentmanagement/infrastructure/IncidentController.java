package dev.wiktorstrzelczyk.incidentmanagement.infrastructure;

import dev.wiktorstrzelczyk.incidentmanagement.application.IncidentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public void addIncidents(@RequestParam("file") MultipartFile file) {
        try {
            incidentService.addIncidents(file.getInputStream());
        } catch (IOException e) {

        }
    }
}
