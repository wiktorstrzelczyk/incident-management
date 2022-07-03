package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsFromInputStreamReader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OpenCsvReader implements IncidentsFromInputStreamReader {
    @Override
    public List<Incident> readFrom(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        CsvToBean<IncidentCsvRecord> csvReader = new CsvToBeanBuilder(reader)
                .withType(IncidentCsvRecord.class)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
        List<IncidentCsvRecord> incidentCsvRecords = csvReader.parse();
        return incidentCsvRecords.stream().map(IncidentCsvRecord::toDomain).collect(Collectors.toList());
    }
}
