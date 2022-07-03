package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.io.InputStream;
import java.util.List;

public interface IncidentsFromInputStreamReader {

    List<Incident> readFrom(InputStream inputStream);
}
