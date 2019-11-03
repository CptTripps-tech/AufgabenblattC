package Aufgabe4;

import java.io.*;
import java.util.ArrayList;

public abstract class BinaryPersistency implements Persistency {

    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            FileOutputStream savefile = new FileOutputStream(dateiname);
            ObjectOutputStream saveout = new ObjectOutputStream(savefile);
        } catch (FileNotFoundException e) {
            System.out.println("Kein Dateiname für Bibliothek angegeben");
        } catch (IOException e) {
            System.out.println("Bibliothek konnte nicht gespeichert werden");
        }

    }
}