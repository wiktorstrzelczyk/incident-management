package dev.wiktorstrzelczyk.incidentmanagement.domain;

import java.util.Objects;

public final class Asset {

    public final String name;

    public Asset(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(name, asset.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
