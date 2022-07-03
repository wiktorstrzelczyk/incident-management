package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.incident;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
interface MongoSpringRepository extends MongoRepository<IncidentDocument, String> {

    List<IncidentDocument> findAllByStartDateGreaterThanEqualAndEndDateLessThan(LocalDateTime startDate, LocalDateTime endDate);
}
