package Aufgabe4;

import java.io.*;
import java.util.ArrayList;

public class BinaryPersistency implements Persistency {

    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            FileOutputStream savefile = new FileOutputStream(dateiname);
            ObjectOutputStream saveout = new ObjectOutputStream(savefile);

            saveout.writeObject(zk);

        } catch (FileNotFoundException e) {
            System.out.println("Kein Dateiname für Bibliothek angegeben");
        } catch (IOException e) {
            System.out.println("Bibliothek konnte nicht gespeichert werden");
        }

    }

    public Zettelkasten load(String dateiname){
        Zettelkasten lk=new Zettelkasten();
        try{
            FileInputStream savein=new FileInputStream(dateiname);
            ObjectInputStream objectin=new ObjectInputStream(savein);
            lk= (Zettelkasten) objectin.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden!");
        } catch (IOException e) {
            System.out.println("Datei konnte nicht eingelesen werden!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lk;
    }
}