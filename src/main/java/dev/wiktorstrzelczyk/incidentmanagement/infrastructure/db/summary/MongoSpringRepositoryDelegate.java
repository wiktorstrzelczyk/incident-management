package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.db.summary;

import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummary;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsStatisticalSummaryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


final class MongoSpringRepositoryDelegate implements IncidentsStatisticalSummaryRepository {

    private final MongoSpringRepository mongoSpringRepository;

    public MongoSpringRepositoryDelegate(MongoSpringRepository mongoSpringRepository) {
        this.mongoSpringRepository = mongoSpringRepository;
    }

    @Override
    public List<IncidentsStatisticalSummary> forDay(LocalDate date) {
        List<IncidentsStatisticalSummaryDocument> documents = mongoSpringRepository.findByDate(date);
        return documents.stream().map(IncidentsStatisticalSummaryDocument::toDomain).collect(Collectors.toList());
    }

    @Override
    public void saveForDate(LocalDate date, List<IncidentsStatisticalSummary> incidentSummaries) {
        List<IncidentsStatisticalSummaryDocument> documents =
                incidentSummaries.stream()
                        .map(domain -> IncidentsStatisticalSummaryDocument.fromDomain(domain, date))
                        .collect(Collectors.toList());
        mongoSpringRepository.saveAll(documents);
    }
}
