package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.incident;

import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentRepository;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incidents;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component("incidents-repository-delegate")
final class MongoSpringRepositoryDelegate implements IncidentRepository {

    private final MongoSpringRepository mongoSpringRepository;

    public MongoSpringRepositoryDelegate(MongoSpringRepository mongoSpringRepository) {
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

    @Override
    public void save(List<Incident> incidents) {
        List<IncidentDocument> documents = incidents.stream().map(IncidentDocument::fromDomain).collect(Collectors.toList());
       mongoSpringRepository.saveAll(documents);
    }
}
