package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsFromInputStreamReader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OpenCsvReader implements IncidentsFromInputStreamReader {
    @Override
    public List<Incident> readFrom(InputStream inputStream) {
        CsvToBean<IncidentCsvRecord> csvReader = csvToBeanReader(inputStream);
        List<IncidentCsvRecord> incidentCsvRecords = csvReader.parse();
        return incidentCsvRecords.stream().map(IncidentCsvRecord::toDomain).collect(Collectors.toList());
    }

    private CsvToBean<IncidentCsvRecord> csvToBeanReader(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        HeaderColumnNameTranslateMappingStrategy strategy = new HeaderColumnNameTranslateMappingStrategy();
        strategy.setType(IncidentCsvRecord.class);
        strategy.setColumnMapping(mapping());
        return new CsvToBeanBuilder(reader)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .build();
    }

    private Map<String, String> mapping() {
        Map mapping = new HashMap();
        mapping.put("Asset Name", "assetName");
        mapping.put("Start Date", "startDate");
        mapping.put("End Time ", "endDate");
        mapping.put("Severity", "severity");
        return mapping;
    }
}
