package Aufgabe4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zettelkasten implements Iterator<Medium>,Iterable<Medium>,Persistency {
    private ArrayList<Medium> myZettelkasten;
    private int sortCounter = 0;

    /**Erstellt einen Zettelkasten in Form einer Arraylist für die Medien*/
    public Zettelkasten() {
        myZettelkasten = new ArrayList<Medium>();
    }

    /**@param medium    Hinzufügen des Mediums zum Zettelkasten
     * @return true     Medium erfolgreich hinzugefügt
     * @return false    Medium nicht erfolgreich hinzugefügt*/
    public boolean addMedium(Medium medium) {
        return myZettelkasten.add(medium);
    }

    /**@param Titel Löschen des Mediums aus dem Zettelkastens anhand des Titels
     * @return true     Medium erfolgreich entfernt
     * @return false    Medium nicht erfolgreich entfernt*/
    public boolean dropMedium(String Titel) {
        int i = 0;
        String dm;
        dm = myZettelkasten.get(i).getTitel();

        while (!dm.equals(Titel) && i < myZettelkasten.size()) {
            dm = myZettelkasten.get(i).getTitel();
            i++;
        }
        if (dm.equals(Titel)) {
            myZettelkasten.remove(i);
        } else {
            throw new ArrayStoreException("Der Titel wurde nicht gefunden");
        }
        return true;
    }

    /**@param Titel Finden eines Mediums im Zettelkasten anhand des Titels
     * @return      Liefert das gefundene Medium zurück*/
    public Medium findMedium(String Titel) {
        int j = 0;
        String fm,nm;
        fm = myZettelkasten.get(j).getTitel();

        while (!fm.equals(Titel) && j < myZettelkasten.size()) {
            fm = myZettelkasten.get(j).getTitel();
            j++;
        }
        if (fm.equals(Titel)) {
            return myZettelkasten.get(j);
        } else {
            return null;
        }
    }

    /**Sortieren des Zettelkastens anhand zwei Parameter
     * @param  a        Der erste Sortier-Parameter
     * @param  b        Der zweite Sortier-Paramater
     * @return true     Sortieren hat funktioniert
     * @return false    Sortieren hat nicht funktioniert*/
    public boolean sort(String a, String b) {
        if (sortCounter == 0) {
            if (a == "A" && b == "Z") {
                Collections.sort(myZettelkasten);
                sortCounter++;
            }
            if (a == "Z" && b == "A") {
                Collections.sort(myZettelkasten, Collections.reverseOrder());
                sortCounter++;
            }
        }
        if (sortCounter == 1) {
            return false;
        }
        return false;
    }


    Iterator<Medium> zk_iterator;

    /**@return true     Medium hat Nachfolger
     * @return false    Medium hat keinen Nachfolger*/
    @Override
    public boolean hasNext() {
        return (zk_iterator != null && zk_iterator.next() != null);
    }

    /**@return Das nächste Medium in der Liste*/
    @Override
    public Medium next() {
        return zk_iterator.next();
    }

    @Override
    public Iterator<Medium> iterator() {
        return zk_iterator = myZettelkasten.iterator();
    }

    /**@param zk            Der zu speichernde Zettelkasten
     * @param dateiname     Der Name der Textdatei*/
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
    public Zettelkasten load(String dateiname) {
        throw new UnsupportedOperationException("Operation nicht erlaubt!");
    }
}

