package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.summary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("incidents-statistical-summary-mongo-spring-repository")
interface MongoSpringRepository extends MongoRepository<IncidentsStatisticalSummaryDocument, String> {

    List<IncidentsStatisticalSummaryDocument> findByDate(LocalDate date);
}
