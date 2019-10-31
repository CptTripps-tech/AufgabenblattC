package Aufgabe4;

import java.util.Comparator;

public abstract class Medium implements Comparable<Medium> {
    private String Titel;
    private java.lang.Object Object;

    public Medium(String titel) {
        this.Titel=titel;
    }

    public void setTitel(String titel) {
        this.Titel=titel;
    }

    public String getTitel() {
        return Titel;
    }

    public abstract int CompareTo(Medium o);

    public abstract String calculateRepresentation();
}
