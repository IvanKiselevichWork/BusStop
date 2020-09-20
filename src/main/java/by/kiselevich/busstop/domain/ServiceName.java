package by.kiselevich.busstop.domain;

public enum ServiceName {
    POSH, GROTTY;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
