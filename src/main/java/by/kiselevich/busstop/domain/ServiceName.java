package by.kiselevich.busstop.domain;

public enum ServiceName {
    POSH("Posh"), GROTTY("Grotty");

    private final String canonicalName;

    ServiceName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    @Override
    public String toString() {
        return canonicalName;
    }
}
