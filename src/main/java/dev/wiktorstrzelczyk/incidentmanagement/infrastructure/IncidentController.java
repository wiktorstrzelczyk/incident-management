package dev.wiktorstrzelczyk.incidentmanagement.infrastructure;

import dev.wiktorstrzelczyk.incidentmanagement.application.IncidentService;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummary;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/statistical-summary")
    public ResponseEntity getStatisticalSummary(LocalDate date) {
        List<IncidentsStatisticalSummary> statisticalSummary = incidentService.getStatisticalSummaryFor(date);
        if(statisticalSummary.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(statisticalSummary);
        }
    }

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity addIncidents(@RequestParam("file") MultipartFile file) {
        try {
            incidentService.addIncidents(file.getInputStream());
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
