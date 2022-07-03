package dev.wiktorstrzelczyk.incidentmanagement.infrastructure.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.wiktorstrzelczyk.incidentmanagement.domain.Incident;
import dev.wiktorstrzelczyk.incidentmanagement.domain.IncidentsFromInputStreamReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

public class OpenCsvReader implements IncidentsFromInputStreamReader {
    @Override
    public List<Incident> readFrom(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        CsvToBean<IncidentCsv> csvReader = new CsvToBeanBuilder(reader)
                .withType(IncidentCsv.class)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
        List<IncidentCsv> incidentCsv = csvReader.parse();
        return incidentCsv.stream().map(IncidentCsv::toDomain).collect(Collectors.toList());
    }
}
