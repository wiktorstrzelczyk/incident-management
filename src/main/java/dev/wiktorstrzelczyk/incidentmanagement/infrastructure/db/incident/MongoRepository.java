package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.incident;

import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentRepository;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incidents;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

final class MongoRepository implements IncidentRepository {

    private final MongoSpringRepository mongoSpringRepository;

    public MongoRepository(MongoSpringRepository mongoSpringRepository) {
        this.mongoSpringRepository = mongoSpringRepository;
    }

    @Override
    public Incidents occurredOn(LocalDate date) {
        List<IncidentDocument> documents = mongoSpringRepository.findAllByStartDateGreaterThanEqualAndEndDateLessThan(
                date.atStartOfDay(),
                date.plusDays(1).atStartOfDay()
        );

       return new Incidents(
               documents.stream().map(IncidentDocument::toDomain).collect(Collectors.toList())
       );
    }
}
