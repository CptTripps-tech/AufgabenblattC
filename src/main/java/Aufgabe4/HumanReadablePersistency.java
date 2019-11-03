package Aufgabe4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class HumanReadablePersistency implements Persistency {
    @Override
    public abstract void save(Zettelkasten zk, String dateiname);

    @Override
    public abstract Zettelkasten load(String dateiname);
}
