package Aufgabe4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HumanReadablePersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            BufferedWriter save = new BufferedWriter(new FileWriter(dateiname));
            for (Medium med : zk) {
                save.write(med.calculateRepresentation());
                save.write("\n");
            }
            save.close();

        } catch (IOException e) {
            System.out.println("Datei konnte nicht eingelesen werden");
        }
    }

    @Override
    public Zettelkasten load(String dateiname) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Operation nicht erlaubt!");
    }
}
