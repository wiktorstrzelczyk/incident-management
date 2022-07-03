package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.summary;

import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
interface MongoSpringRepository extends MongoRepository<IncidentsStatisticalSummaryDocument, String> {

    List<IncidentsStatisticalSummaryDocument> findByDate(LocalDate date);
}
