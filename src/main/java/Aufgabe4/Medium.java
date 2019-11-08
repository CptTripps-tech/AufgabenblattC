package Aufgabe4;

import java.util.Comparator;

public abstract class Medium implements Comparable<Medium> {
    private String Titel;

    /**@param titel Titel des Mediums*/
    public Medium(String titel) {
        if (titel == "" || titel == null) {
            throw new IllegalArgumentException("Titel fehlt!");
        } else {
            this.Titel = titel;
        }
    }
    public void setTitel(String titel) {
        this.Titel=titel;
    }

    /**@return Titel des Mediums*/
    public String getTitel() {
        return Titel;
    }

    /**@param medium Das Medium mit dem verglichen wird*/
    public int compareTo(Medium medium){
        return this.getTitel().compareTo(medium.getTitel());
    }

    public abstract String calculateRepresentation();
}
