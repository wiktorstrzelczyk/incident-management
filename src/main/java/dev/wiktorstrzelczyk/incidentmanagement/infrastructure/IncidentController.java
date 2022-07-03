package dev.wiktorstrzelczyk.incidentmanagement.infrastructure;

import dev.wiktorstrzelczyk.incidentmanagement.application.IncidentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Controller
@RequestMapping("/incidents")
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

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity addRandomIncident() {
        incidentService.addIncident();
        return ResponseEntity.ok().build();
    }

}
